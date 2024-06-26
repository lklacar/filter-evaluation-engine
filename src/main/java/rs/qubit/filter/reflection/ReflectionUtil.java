package rs.qubit.filter.reflection;

import rs.qubit.filter.exception.FilterException;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ReflectionUtil {

    public static Map<String, Object> getFields(Object object) {
        try {
            var fields = Introspector.getBeanInfo(object.getClass()).getPropertyDescriptors();
            var map = new HashMap<String, Object>();
            for (var field : fields) {
                if (field.getName().equals("class")) {
                    continue;
                }
                var isAccessible = field.getReadMethod().canAccess(object);
                field.getReadMethod().setAccessible(true);
                var value = field.getReadMethod().invoke(object);
                field.getReadMethod().setAccessible(isAccessible);

                var isPrimitive = field.getPropertyType().isPrimitive();
                var isIterable = Iterable.class.isAssignableFrom(field.getPropertyType());
                var isArray = field.getPropertyType().isArray();
                var isMap = Map.class.isAssignableFrom(field.getPropertyType());
                var isEnum = field.getPropertyType().isEnum();
                var isString = field.getPropertyType().equals(String.class);
                var isDateTime = field.getPropertyType().equals(java.time.LocalDate.class) || field.getPropertyType().equals(java.time.LocalDateTime.class);
                var isObject = !isPrimitive && !isIterable && !isArray && !isMap && !isEnum && !isString && !isDateTime;
                var isNull = value == null;

                if (isNull) {
                    map.put(field.getName(), null);
                } else if (isPrimitive || isString || isEnum) {
                    map.put(field.getName(), value);
                } else if (isIterable) {
                    var list = (Iterable<?>) value;
                    var listMap = new HashMap<Integer, Object>();
                    var i = 0;
                    for (var item : list) {
                        listMap.put(i++, item);
                    }
                    map.put(field.getName(), listMap);
                } else if (isArray) {
                    var array = (Object[]) value;
                    var arrayMap = new HashMap<Integer, Object>();
                    for (var i = 0; i < array.length; i++) {
                        arrayMap.put(i, array[i]);
                    }
                    map.put(field.getName(), arrayMap);
                } else if (isMap) {
                    var mapValue = (Map<?, ?>) value;
                    var mapMap = new HashMap<Object, Object>();
                    for (var entry : mapValue.entrySet()) {
                        mapMap.put(entry.getKey(), entry.getValue());
                    }
                    map.put(field.getName(), mapMap);
                } else if (isDateTime) {
                    map.put(field.getName(), value);
                } else if (isObject) {
                    map.put(field.getName(), getFields(value));
                } else {
                    throw new FilterException("Unsupported field type: " + field.getPropertyType());
                }

            }

            return map;
        } catch (InvocationTargetException | IllegalAccessException | IntrospectionException e) {
            throw new FilterException("Error while getting field value", e);
        }
    }

}
