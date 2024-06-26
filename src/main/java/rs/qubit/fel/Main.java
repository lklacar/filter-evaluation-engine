package rs.qubit.fel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.qubit.fel.generation.PostgreSQLGenerationContext;
import rs.qubit.fel.generation.PostgreSQLGenerator;

import java.time.Instant;


public class Main {

    public static void main(String[] args) {
        var predicate = Fel.filter("toUppercase(firstName) = 'JOHN' || age > 18");

        var postgreSQLGenerator = new PostgreSQLGenerator();
        var postgreSQLGenerationContext = new PostgreSQLGenerationContext();

        var sql = predicate.generate(postgreSQLGenerator, postgreSQLGenerationContext);

        System.out.println(sql);
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
