package baseball;

import java.lang.reflect.Method;

public abstract class BaseTest<T> {

    protected Method getPrivateMethod(T targetClass, String MethodName, Class<?>... classObject) {
        Method method = null;
        try {
            method = targetClass.getClass().getDeclaredMethod(MethodName, classObject);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        method.setAccessible(true);
        return method;
    }

}
