package baseball.util;

import java.lang.reflect.Field;

public class TestUtil {

    public static Object getPrivateVariable(Object object, String variableName) throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getDeclaredField(variableName);
        field.setAccessible(true);
        return field.get(object);
    }
}
