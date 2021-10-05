package baseball.validator;

import baseball.exception.ValidationException;
import baseball.message.error.ErrorCode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class InputValidatorTest {

    @Test
    @DisplayName("3자리수가 아니면 에러 메시지를 반환")
    void validateInput1()  {
        //given
        final String input = "123213";
        //when && then
        assertThatThrownBy(() -> InputValidator.validateInput(input))
                .isInstanceOf(ValidationException.class)
                .hasMessage(ErrorCode.VALIDATE_EXCEPTION_IS_NOT_THREE_DIGITS);

    }

    @Test
    @DisplayName("문자열이 들어가있으면 에러 메시지를 반환")
    void validateInput2() {
        //given
        final String input = "a23";
        //when && then
        assertThatThrownBy(() -> InputValidator.validateInput(input))
                .isInstanceOf(ValidationException.class)
                .hasMessage(ErrorCode.VALIDATE_EXCEPTION_IS_NOT_NUMBER_OR_CONTAIN_ZERO);

    }

    @Test
    @DisplayName("0이 들어가있으면 에러 메시지를 반환")
    void validateInput3() {
        //given
        final String input = "023";
        //when && then
        assertThatThrownBy(() -> InputValidator.validateInput(input))
                .isInstanceOf(ValidationException.class)
                .hasMessage(ErrorCode.VALIDATE_EXCEPTION_IS_NOT_NUMBER_OR_CONTAIN_ZERO);

    }

    @Test
    @DisplayName("중복되는 숫자가 들어가있으면 에러 메시지를 반환")
    void validateInput4() {
        //given
        final String input = "113";
        //when && then
        assertThatThrownBy(() -> InputValidator.validateInput(input))
                .isInstanceOf(ValidationException.class)
                .hasMessage(ErrorCode.VALIDATE_EXCEPTION_IS_DUPLICATE);
    }
}