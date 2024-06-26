package rs.qubit.fel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;


public class Main {

    public static void main(String[] args) {
        var predicate = Fel.filter("toUppercase(firstName) = 'JOHN' || age > 18");
        var ast = predicate.getAst();

        var predicateFromAst = Fel.fromAst(ast);

        System.out.println(ast);
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
