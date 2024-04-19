package rs.qubit;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import rs.qubit.ast.*;
import rs.qubit.value.BooleanValue;
import rs.qubit.visitor.ExpressionEvaluatorVisitor;
import rs.qubit.visitor.SqlGeneratorVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static rs.qubit.Query.*;

public class Main {

    @SuppressWarnings("DataFlowIssue")
    public static List<Record> generateRecords() {

        var result = new ArrayList<Record>(10000000);
        for (int i = 0; i < 10000000; i++) {
            var record = new Record();
            record.put("name", "John %d".formatted(i));
            record.put("age", i);
            record.put("city", "City %d".formatted(i));
            result.add(record);
        }

        return result;
    }


    @SneakyThrows
    public static void main(String[] args) {

        var expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor();

        System.out.println("Generating data...");

        var generatingStart = System.currentTimeMillis();
        var records = generateRecords();
        var generatingEnd = System.currentTimeMillis();
        System.out.println("Data generated in %d ms".formatted(generatingEnd - generatingStart));


        var filter = or(
                equal(
                        column("name"),
                        string("John 7")
                ),
                equal(
                        column("age"),
                        integer(25)
                ),
                equal(
                        column("city"),
                        string("City 65")
                )
        );

        var serializedFilter = new ObjectMapper().writeValueAsString(filter);
        var deserializedFilter = new ObjectMapper().readValue(serializedFilter, ExpressionNode.class);

        var start = System.currentTimeMillis();
        System.out.println("Starting benchmark");


        var filteredRecords = records
                .stream()
                .parallel()
                .filter(record -> {
                    var shouldExist = expressionEvaluatorVisitor.visit(filter, record);
                    return shouldExist instanceof BooleanValue && ((BooleanValue) shouldExist).isValue();
                })
                .toList();

        var end = System.currentTimeMillis();
        System.out.printf("Filtering took: %d ms\n", end - start);
        System.out.printf("Original records: %d\n", records.size());
        System.out.printf("Filtered records: %d\n", filteredRecords.size());

        System.out.println("Filtering using Java streams");
        var start2 = System.currentTimeMillis();
        var filteredRecords2 = records
                .stream()
                .filter(record -> {
                    var name = record.get("name");
                    var age = record.get("age");
                    var city = record.get("city");

                    return name.equals("John 7") || age.equals(25) || city.equals("City 65");
                })
                .toList();
        var end2 = System.currentTimeMillis();
        System.out.printf("Filtering took: %d ms\n", end2 - start2);
        System.out.printf("Original records: %d\n", records.size());
        System.out.printf("Filtered records: %d\n", filteredRecords2.size());



        var sqlGeneratorVisitor = new SqlGeneratorVisitor();
        var sql = "WHERE %s".formatted(filter.accept(sqlGeneratorVisitor, new Record()));
        System.out.println(sql);


    }
}