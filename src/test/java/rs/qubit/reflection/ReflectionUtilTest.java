package rs.qubit.reflection;

import lombok.Data;
import lombok.Getter;
import rs.qubit.filter.reflection.ReflectionUtil;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ReflectionUtilTest {

    enum TestEnum {
        // enum with all types of fields
        // primitive
        PRIMITIVE_INT(1),
        PRIMITIVE_LONG(1L),
        PRIMITIVE_DOUBLE(1.0),
        PRIMITIVE_FLOAT(1.0f),
        PRIMITIVE_BOOLEAN(true),
        PRIMITIVE_CHAR('a'),
        PRIMITIVE_BYTE((byte) 1),
        PRIMITIVE_SHORT((short) 1),
        // string
        STRING("string"),
        // object
        OBJECT(new TestClass()),
        // iterable
        LIST(List.of("list")),
        SET(Set.of("set")),
        // array
        ARRAY(new String[]{"array"}),
        // map
        MAP(Map.of("key", "value"));

        @Getter
        private final Object value;

        TestEnum(Object value) {
            this.value = value;
        }
    }

    @Data
    static class TestClass {
        // class with all types of fields
        // primitive
        private int primitiveInt;
        private long primitiveLong;
        private double primitiveDouble;
        private float primitiveFloat;
        private boolean primitiveBoolean;
        private char primitiveChar;
        private byte primitiveByte;
        private short primitiveShort;
        // string
        private String string;
        // enum
        private TestEnum testEnum;
        // object
        private TestClass testClass;
        // iterable
        private List<String> list;
        private Set<String> set;
        // array
        private String[] array;
        // map
        private Map<String, String> map;

    }

    @org.junit.jupiter.api.Test
    void getFields() {
        var testClass = new TestClass();
        testClass.setPrimitiveInt(1);
        testClass.setPrimitiveLong(1L);
        testClass.setPrimitiveDouble(1.0);
        testClass.setPrimitiveFloat(1.0f);
        testClass.setPrimitiveBoolean(true);
        testClass.setPrimitiveChar('a');
        testClass.setPrimitiveByte((byte) 1);
        testClass.setPrimitiveShort((short) 1);
        testClass.setString("string");
        testClass.setTestEnum(TestEnum.PRIMITIVE_INT);
        testClass.setTestClass(new TestClass());
        testClass.setList(List.of("list"));
        testClass.setSet(Set.of("set"));
        testClass.setArray(new String[]{"array"});
        testClass.setMap(Map.of("key", "value"));

        var fields = ReflectionUtil.getFields(testClass);
        assertEquals(15, fields.size());
        assertEquals(1, fields.get("primitiveInt"));
        assertEquals(1L, fields.get("primitiveLong"));
        assertEquals(1.0, fields.get("primitiveDouble"));
        assertEquals(1.0f, fields.get("primitiveFloat"));
        assertEquals(true, fields.get("primitiveBoolean"));
        assertEquals('a', fields.get("primitiveChar"));
        assertEquals((byte) 1, fields.get("primitiveByte"));
        assertEquals((short) 1, fields.get("primitiveShort"));
        assertEquals("string", fields.get("string"));
        assertEquals(TestEnum.PRIMITIVE_INT, fields.get("testEnum"));
        assertEquals(Map.of(0, "list"), fields.get("list"));
        assertEquals(Map.of(0, "set"), fields.get("set"));
        assertEquals(Map.of(0, "array"), fields.get("array"));
        assertEquals(Map.of("key", "value"), fields.get("map"));
    }
}