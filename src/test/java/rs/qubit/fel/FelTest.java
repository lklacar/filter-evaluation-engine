package rs.qubit.fel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FelTest {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    static class Address {
        private String city;
        private String street;
        private int number;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    static class User {
        private String name;
        private int age;
        private LocalDateTime createdAt;
        private Address address;
    }


    @Test
    void filter() {
        var users = List.of(
                new User("John", 25, LocalDateTime.now(), new Address("Belgrade", "Nemanjina", 4)),
                new User("Jane", 30, LocalDateTime.now(), new Address("Novi Sad", "Trg Slobode", 1)),
                new User("Mark", 35, LocalDateTime.now(), new Address("Belgrade", "Knez Mihailova", 2)),
                new User("Marko", 35, LocalDateTime.now(), new Address("Belgrade", "Knez Mihailova", 2)),
                new User("Marko", 35, LocalDateTime.now(), new Address("Belgrade", "Knez Mihailova", 2))
        );

        var filter = Fel.filter("age > 30 AND address.city = 'Belgrade'");

        var filteredUsers = users.stream().filter(filter).toList();

        assertEquals(3, filteredUsers.size());
        assertEquals("Mark", filteredUsers.get(0).getName());
        assertEquals("Marko", filteredUsers.get(1).getName());


    }
}