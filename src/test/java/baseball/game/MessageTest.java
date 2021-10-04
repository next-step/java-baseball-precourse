package baseball.game;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

class MessageTest {

    @Test
    public void testMakeMessage() {
        testMakeMessage(1, 2);
        testMakeMessage(0, 0);
        testMakeMessage(1, 0);
        testMakeMessage(0, 1);
    }

    private void testMakeMessage(int strikeCount, int ballCount) {
        String message = getMessage(strikeCount, ballCount);

        if(strikeCount > 0) {
            String strikeText = strikeCount + "스트라이크";
            assertThat(message.contains(strikeText)).isTrue();
        }
        if(ballCount > 0) {
            String ballText = ballCount + "볼";
            assertThat(message.contains(ballText)).isTrue();
        }
        if(strikeCount == 0 && ballCount == 0) {
            assertThat("낫싱".equals(message)).isTrue();
        }
    }

    private String getMessage(int strikeCount, int ballCount) {
        Message message = new Message();
        Method method = null;
        try {
            method = message.getClass().getDeclaredMethod("makeMessage", int.class, int.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        method.setAccessible(true);
        try {
            return  (String) method.invoke(message, strikeCount, ballCount);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}