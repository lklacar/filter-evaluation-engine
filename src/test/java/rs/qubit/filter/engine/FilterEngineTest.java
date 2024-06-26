package rs.qubit.filter.engine;

import lombok.Data;
import org.junit.jupiter.api.Test;
import rs.qubit.filter.evaluator.value.DateTimeValue;
import rs.qubit.filter.evaluator.value.Value;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Map;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class FilterEngineTest {

    @Data
    static class Person {
        private String name;
        private int age;
        private Instant dateOfBirth;
    }

    @Test
    void filter() {

        var filterEngine = FilterEngine.builder()
                .withAdditionalMapper(Instant.class, value -> {
                    var localDateTime = value.atZone(ZoneId.systemDefault()).toLocalDateTime();
                    return new DateTimeValue(localDateTime);
                })
                .build();

        var filter = "dateOfBirth > 2021-01-01T00:00:00Z";


        var john = new Person();
        john.setName("John");
        john.setAge(30);
        john.setDateOfBirth(Instant.now());

        var jane = new Person();
        jane.setName("Jane");
        jane.setAge(25);
        jane.setDateOfBirth(Instant.now());

        var people = java.util.List.of(john, jane);

        var filteredPeople = filterEngine.filter(people.stream(), filter).toList();

        System.out.println(filteredPeople);

    }
}