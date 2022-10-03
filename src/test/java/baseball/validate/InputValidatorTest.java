package baseball.validate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"12345", "2343", "12", "2"})
    void 입력_길이_예외_체크(){
        String input = "12453";

        assertThatIllegalArgumentException().isThrownBy(
                () -> InputValidator.validateInputLength(input)
        ).withMessage("자릿수 입력이 옳바르지 않습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"동하12", "숫자야구", " 12", "bas"})
    void 입력_문자_예외_체크(){
        String input = "동하12";

        assertThatIllegalArgumentException().isThrownBy(
                () -> InputValidator.validateInputNumber(input)
        ).withMessage("숫자 외 입력이 확인되었습니다.");
    }
}