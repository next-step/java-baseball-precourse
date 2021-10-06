package baseball;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {
    @DisplayName("세글자 이상의 입력")
    @Test
    void inputLengtExceed() throws UserInputNumberException{
        String input = "1234";
        assertThatExceptionOfType(UserInputNumberException.class)
                .isThrownBy(() -> Player.checkInputLength(input)).withMessageContaining(OutputView.MSG_INPUT_LENGTH);
    }

    @DisplayName("숫자가 아닌 문자 입력")
    @Test
    void inputNotNumber() {
        String input = "가나다";
        assertThatExceptionOfType(UserInputNumberException.class)
                .isThrownBy(() -> Player.checkNumberValidate(input)).withMessageContaining(OutputView.MSG_NUMBER_VALIDATE);
    }

    @DisplayName("중복된 문자 입력")
    @Test
    void inputDuplicateNumber() {
        String input = "112";

        assertThatExceptionOfType(UserInputNumberException.class)
                .isThrownBy(() -> Player.checkDuplicate(input)).withMessageContaining(OutputView.MSG_DUPLICATE_VALUE);
    }

    @DisplayName("1-9가 아닌 숫자 입력")
    @Test
    void inputOutOfRangeNumber () {
        String input = "012";

        assertThatExceptionOfType(UserInputNumberException.class)
                .isThrownBy(() -> Player.checkNumberValidate(input)).withMessageContaining(OutputView.MSG_NUMBER_VALIDATE);
    }
}
