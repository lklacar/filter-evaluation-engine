package rs.qubit.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.qubit.filter.engine.FilterEngine;

import java.time.LocalDateTime;
import java.util.List;

public class Main {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class User {
        private String firstName;
        private String lastName;
        private int age;
        private LocalDateTime createdAt = LocalDateTime.now();
    }

    public static void main(String[] args) {

        var filterEngine = new FilterEngine();

        var users = List.of(
            new User("John", "Doe", 30, LocalDateTime.now().minusDays(1)),
            new User("Jane", "Doe", 25, LocalDateTime.now().minusDays(2)),
            new User("Alice", "Smith", 35, LocalDateTime.now().minusDays(3)),
            new User("Bob", "Smith", 40, LocalDateTime.now().minusDays(4))
        );

        var filteredUsers = filterEngine.filter(
                users.stream(),
                "createdAt > 2021-01-01T00:00:00"
        );

        filteredUsers.forEach(System.out::println);


    }
}
