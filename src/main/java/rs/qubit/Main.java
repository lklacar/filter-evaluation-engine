package rs.qubit;

import rs.qubit.ast.*;
import rs.qubit.value.BooleanValue;
import rs.qubit.visitor.ExpressionEvaluatorVisitor;
import rs.qubit.visitor.SqlGeneratorVisitor;

import java.util.List;

import static rs.qubit.Query.*;

public class Main {

    @SuppressWarnings("DataFlowIssue")
    public static List<Record> generateRecords() {
        return List.of(
                new Record().put("name", "John").put("age", 25).put("city", "New York"),
                new Record().put("name", "Jane").put("age", 30).put("city", "Los Angeles"),
                new Record().put("name", "Doe").put("age", 35).put("city", "San Francisco"),
                new Record().put("name", "John Doe").put("age", 40).put("city", "Las Vegas"),
                new Record().put("name", "Jane Doe").put("age", 45).put("city", "Miami"),
                new Record().put("name", "John Smith").put("age", 50).put("city", "Chicago"),
                new Record().put("name", "Jane Smith").put("age", 55).put("city", "Houston"),
                new Record().put("name", "John Johnson").put("age", 60).put("city", "Philadelphia"),
                new Record().put("name", "Jane Johnson").put("age", 65).put("city", "Phoenix"),
                new Record().put("name", "John Williams").put("age", 70).put("city", "San Antonio")
        );
    }


    public static void main(String[] args) {

        var expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor();

        var records = generateRecords();


        var filter = not(and(
                not(
                        like(
                                column("name"),
                                string("%John%")
                        )
                ),
                not(
                        greaterThan(
                                column("age"),
                                number(100)
                        )
                ),
                or(
                        equal(
                                column("city"),
                                string("New York")
                        ),
                        equal(
                                column("city"),
                                string("Los Angeles")
                        )
                )
        ));


        var filteredRecords = records
                .stream()
                .filter(record -> {
                    var shouldExist = expressionEvaluatorVisitor.visit(filter, record);
                    return shouldExist instanceof BooleanValue && ((BooleanValue) shouldExist).isValue();
                })
                .toList();

        System.out.println(filter);

        System.out.printf("Original records: %d\n", records.size());
        System.out.printf("Filtered records: %d\n", filteredRecords.size());


        var sqlGeneratorVisitor = new SqlGeneratorVisitor();
        var sql = "WHERE %s".formatted(filter.accept(sqlGeneratorVisitor, new Record()));
        System.out.println(sql);


    }
}