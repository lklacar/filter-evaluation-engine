package rs.qubit.fel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.qubit.fel.evaluator.value.DateTimeValue;

import java.time.Instant;
import java.time.ZoneId;
import java.util.List;


public class Main {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    static class User {
        private String firstName;
        private String lastName;
        private Instant dateOfBirth;
    }

    public static void main(String[] args) {

        var users = List.of(
                new User("John", "Doe", Instant.parse("1990-01-01T00:00:00Z")),
                new User("Jane", "Doe", Instant.parse("1995-01-01T00:00:00Z"))
        );

        var predicate = Fel.filter("dateOfBirth = 1992-01-01T00:00:00")
                .withMapper(Instant.class, instant -> {
                    var localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
                    return new DateTimeValue(localDateTime);
                });

        var filteredUsers = users.stream()
                .filter(predicate)
                .toList();

        System.out.println(filteredUsers);


    }
}
