package baseball.game;

import baseball.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

class MessageTest extends BaseTest<Message> {

    @DisplayName("입력 결과 문구 생성 검증")
    @ParameterizedTest
    @CsvSource({
            "1, 2",
            "0, 0",
            "1, 0",
            "0, 1"
    })
    void testMakeMessage(int strikeCount, int ballCount) throws InvocationTargetException, IllegalAccessException {
        Message messageObject = new Message();
        Method method = super.getPrivateMethod(messageObject, "makeMessage", int.class, int.class);
        String message = (String) method.invoke(messageObject, strikeCount, ballCount);

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
}