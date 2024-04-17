package rs.qubit;

import rs.qubit.ast.*;
import rs.qubit.value.BooleanValue;
import rs.qubit.visitor.ExpressionEvaluatorVisitor;
import rs.qubit.visitor.SqlGeneratorVisitor;

import java.util.List;

public class Main {

    @SuppressWarnings("DataFlowIssue")
    public static List<Record> generateRecords() {
        return List.of(
            new Record().put("name", "John").put("age", 25).put("city", "New York"),
            new Record().put("name", "Jane").put("age", 30).put("city", "Los Angeles"),
            new Record().put("name", "Doe").put("age", 35).put("city", "San Francisco")
        );
    }


    public static void main(String[] args) {

        var expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor();

        var records = generateRecords();



        var filter = NotExpression
                .builder()
                        .expression(
        AndExpressionNode
                .builder()
                .left(EqualsNode
                        .builder()
                        .left(ColumnNameExpression
                                .builder()
                                .columnName("name")
                                .build())
                        .right(StringExpression
                                .builder()
                                .value("John")
                                .build())
                        .build())
                .right(EqualsNode
                        .builder()
                        .left(ColumnNameExpression
                                .builder()
                                .columnName("age")
                                .build())
                        .right(NumberExpression
                                .builder()
                                .value(25)
                                .build())
                        .build())
                .build()
                        )
                .build();


        var filteredRecords = records
                .stream()
                .filter(record -> {
                    var shouldExist = expressionEvaluatorVisitor.visit(filter, record);
                    return shouldExist instanceof BooleanValue && ((BooleanValue) shouldExist).isValue();
                })
                .toList();


        System.out.printf("Original records: %d\n", records.size());
        System.out.printf("Filtered records: %d\n", filteredRecords.size());


        var sqlGeneratorVisitor = new SqlGeneratorVisitor();
        var sql = "WHERE %s".formatted(filter.accept(sqlGeneratorVisitor, new Record()));
        System.out.println(sql);









    }
}