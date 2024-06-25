package rs.qubit.filter.engine;

import lombok.Data;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilterEngineTest {

    @Data
    static class Person {
        private String name;
        private int age;
    }

    @Test
    void filter() {

        var filterEngine = new FilterEngine();

        var filter = "name = 'John'";


        var john = new Person();
        john.setName("John");
        john.setAge(30);

        var jane = new Person();
        jane.setName("Jane");
        jane.setAge(25);

        var people = java.util.List.of(john, jane);

        var filteredPeople = filterEngine.filter(people.stream(), filter).toList();

        System.out.println(filteredPeople);

    }
}