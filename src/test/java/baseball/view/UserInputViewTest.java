package baseball.view;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

class UserInputViewTest {
    @DisplayName("입력요청 문구 확인")
    @Test
    void requestMessage() {
        UserInputView view = new UserInputView(new InputReader() {
            @Override
            public List<Integer> readBallNumber() {
                return null;
            }
        });

        OutputStream capture = new ByteOutputStream();
        System.setOut(new PrintStream(capture));
        List<Integer> inputResult = view.inputUserNumber();

        Assertions.assertThat(capture.toString())
                .contains("숫자를 입력해주세요");
    }
}