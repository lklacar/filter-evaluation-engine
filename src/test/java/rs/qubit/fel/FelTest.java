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

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    static class Product {
        private String name;
        private double price;
        private boolean inStock;
    }

    @Test
    void filterUsersByAgeAndCity() {
        var users = List.of(
                new User("John", 25, LocalDateTime.now(), new Address("Belgrade", "Nemanjina", 4)),
                new User("Jane", 30, LocalDateTime.now(), new Address("Novi Sad", "Trg Slobode", 1)),
                new User("Mark", 35, LocalDateTime.now(), new Address("Belgrade", "Knez Mihailova", 2)),
                new User("Marko", 35, LocalDateTime.now(), new Address("Belgrade", "Knez Mihailova", 2))
        );

        var filter = Fel.filter("age >= 30 && address.city = 'Belgrade'");

        var filteredUsers = users.stream().filter(filter).toList();

        assertEquals(2, filteredUsers.size());
        assertEquals("Mark", filteredUsers.get(0).getName());
        assertEquals("Marko", filteredUsers.get(1).getName());
    }

    @Test
    void filterProductsByPriceAndStock() {
        var products = List.of(
                new Product("Laptop", 1200.00, true),
                new Product("Smartphone", 700.00, false),
                new Product("Tablet", 300.00, true),
                new Product("Monitor", 150.00, true)
        );

        var filter = Fel.filter("price < 500 && inStock = true");

        var filteredProducts = products.stream().filter(filter).toList();

        assertEquals(2, filteredProducts.size());
        assertEquals("Tablet", filteredProducts.get(0).getName());
        assertEquals("Monitor", filteredProducts.get(1).getName());
    }

    @Test
    void filterNewUsers() {
        var now = LocalDateTime.now();
        var users = List.of(
                new User("Alice", 22, now.minusDays(1), new Address("Paris", "Rue de Rivoli", 7)),
                new User("Bob", 28, now.minusMonths(6), new Address("Berlin", "Unter den Linden", 5)),
                new User("Charlie", 35, now, new Address("London", "Baker Street", 221))
        );

        var filter = Fel.filter("createdAt > " + now.minusHours(3));

        var filteredUsers = users.stream().filter(filter).toList();

        assertEquals(1, filteredUsers.size());
        assertEquals("Charlie", filteredUsers.get(0).getName());
    }

    @Test
    void filterByMultipleConditions() {
        var users = List.of(
                new User("Dave", 44, LocalDateTime.now(), new Address("New York", "Fifth Avenue", 1)),
                new User("Eve", 34, LocalDateTime.now(), new Address("San Francisco", "Market Street", 2)),
                new User("Frank", 29, LocalDateTime.now(), new Address("New York", "Broadway", 3))
        );

        var filter = Fel.filter("age > 30 && address.city = 'New York'");

        var filteredUsers = users.stream().filter(filter).toList();

        assertEquals(1, filteredUsers.size());
        assertEquals("Dave", filteredUsers.get(0).getName());
    }

    @Test
    void filterByNegation() {
        var users = List.of(
                new User("John", 25, LocalDateTime.now(), new Address("New York", "Fifth Avenue", 1)),
                new User("Alice", 30, LocalDateTime.now(), new Address("Los Angeles", "Sunset Boulevard", 2)),
                new User("Bob", 25, LocalDateTime.now(), new Address("New York", "Fifth Avenue", 1))
        );

        var filter = Fel.filter("! (age = 25)");

        var filteredUsers = users.stream().filter(filter).toList();

        assertEquals(1, filteredUsers.size());
        assertEquals("Alice", filteredUsers.get(0).getName());
    }

    @Test
    void filterByLogicalOr() {
        var users = List.of(
                new User("John", 28, LocalDateTime.now(), new Address("San Francisco", "Market Street", 3)),
                new User("Alice", 22, LocalDateTime.now(), new Address("New York", "Wall Street", 12)),
                new User("Bob", 31, LocalDateTime.now(), new Address("San Francisco", "Market Street", 3))
        );

        var filter = Fel.filter("age < 25 || address.city = 'San Francisco'");

        var filteredUsers = users.stream().filter(filter).toList();

        assertEquals(3, filteredUsers.size());
        assertEquals("John", filteredUsers.get(0).getName());
        assertEquals("Alice", filteredUsers.get(1).getName());
        assertEquals("Bob", filteredUsers.get(2).getName());
    }

    @Test
    void filterByComparisonAndGrouping() {
        var users = List.of(
                new User("John", 28, LocalDateTime.now(), new Address("San Francisco", "Market Street", 3)),
                new User("Alice", 22, LocalDateTime.now(), new Address("New York", "Wall Street", 12)),
                new User("Bob", 31, LocalDateTime.now(), new Address("San Francisco", "Market Street", 3))
        );

        var filter = Fel.filter("(age >= 25 && address.city = 'San Francisco') || (age < 25 && address.city = 'New York')");

        var filteredUsers = users.stream().filter(filter).toList();

        assertEquals(3, filteredUsers.size());
        assertEquals("John", filteredUsers.get(0).getName());
        assertEquals("Alice", filteredUsers.get(1).getName());
        assertEquals("Bob", filteredUsers.get(2).getName());
    }

    @Test
    void filterByInequality() {
        var users = List.of(
                new User("John", 28, LocalDateTime.now(), new Address("San Francisco", "Market Street", 3)),
                new User("Alice", 22, LocalDateTime.now(), new Address("New York", "Wall Street", 12)),
                new User("Bob", 31, LocalDateTime.now(), new Address("San Francisco", "Market Street", 3))
        );

        var filter = Fel.filter("age != 28");

        var filteredUsers = users.stream().filter(filter).toList();

        assertEquals(2, filteredUsers.size());
        assertEquals("Alice", filteredUsers.get(0).getName());
        assertEquals("Bob", filteredUsers.get(1).getName());
    }

    @Test
    void filterByNull() {
        var users = List.of(
                new User("John", 28, LocalDateTime.now(), new Address("San Francisco", "Market Street", 3)),
                new User("Alice", 22, LocalDateTime.now(), new Address("New York", "Wall Street", 12)),
                new User("Bob", 31, LocalDateTime.now(), new Address("San Francisco", "Market Street", 3))
        );

        var filter = Fel.filter("address = null");

        var filteredUsers = users.stream().filter(filter).toList();

        assertEquals(0, filteredUsers.size());
    }
}
