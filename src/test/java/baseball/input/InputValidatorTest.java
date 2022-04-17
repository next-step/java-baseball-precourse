package baseball.input;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class InputValidatorTest {
    private final InputValidator inputValidator = new InputValidator();

    @Test
    @DisplayName("중복체크 테스트")
    void hasDuplicateNumberTest() {
        String badInput = "221";
        assertThatThrownBy(()-> {
            inputValidator.hasDuplicateNumber(badInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자체크 테스트")
    void isInputNumberTest() {
        String badInput = "ㅋ1ㅋ";
        assertThatThrownBy(()-> {
            inputValidator.isInputNumber(badInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("세자리체크 테스트")
    void isInputThreeDigitsTest() {
        String badInput = "2212";
        assertThatThrownBy(()-> {
            inputValidator.isInputThreeDigits(badInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}