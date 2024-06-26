package rs.qubit.reflection;

import lombok.Data;
import rs.qubit.filter.reflection.ReflectionUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReflectionUtilTest {


    @Data
    static class TestClass {
        private String string;

    }

    @org.junit.jupiter.api.Test
    void accessField() {
        var testClass = new TestClass();
        testClass.setString("test");
        var value = ReflectionUtil.accessField(testClass, "string");
        assertEquals("test", value);
    }
}