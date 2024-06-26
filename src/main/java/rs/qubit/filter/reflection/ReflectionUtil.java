package rs.qubit.filter.reflection;

public class ReflectionUtil {

    public static Object accessField(Object object, String fieldName) {
        try {
            var field = object.getClass().getDeclaredField(fieldName);
            var isAccessible = field.canAccess(object);
            field.setAccessible(true);
            var result = field.get(object);
            field.setAccessible(isAccessible);
            return result;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
