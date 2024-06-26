package rs.qubit.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.qubit.filter.engine.FilterEngine;

import java.util.List;

import static rs.qubit.filter.engine.FilterEngine.fel;

public class Main {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    static class Address {
        private String street;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    static class User {
        private String firstName;
        private String lastName;
        private Address address;
    }

    public static void main(String[] args) {

        var users = List.of(
                User.builder().firstName("John").lastName("Doe").address(Address.builder().street("Wall Street").build()).build(),
                User.builder().firstName("Jane").lastName("Doe").address(Address.builder().street("Wall Street").build()).build(),
                User.builder().firstName("Alice").lastName("Smith").address(Address.builder().street("Main Street").build()).build()
        );

        var filteredUsers = users
                .stream()
                .filter(fel("address.street = 'Main Street'"))
                .toList();

        System.out.println(filteredUsers);

    }
}
