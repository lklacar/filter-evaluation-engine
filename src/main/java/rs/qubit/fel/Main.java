package rs.qubit.fel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.qubit.fel.evaluator.DefaultEvaluationContext;
import rs.qubit.fel.evaluator.value.NullValue;
import rs.qubit.fel.evaluator.value.StringValue;

import java.time.Instant;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        var users = List.of(
                new User("John", "Doe", Instant.parse("1990-01-01T00:00:00Z")),
                new User("Jane", "Doe", Instant.parse("1995-01-01T00:00:00Z"))
        );

        var context = new DefaultEvaluationContext();
        context.addFunction("toUppercase", values -> {
            var parameter = values.get(0);
            if (parameter instanceof NullValue) {
                return new NullValue();
            }

            return new StringValue(parameter.asString().toUpperCase());
        });


        var filterFactory = new FilterFactory(context);
        var predicate = filterFactory.crateFilter("toUppercase(firstName) = 'JOHN'");


        var filteredUsers = users.stream()
                .filter(predicate)
                .toList();

        System.out.println(filteredUsers);


    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    static class User {
        private String firstName;
        private String lastName;
        private Instant dateOfBirth;
    }
}
