package baseball.input;

import static org.assertj.core.api.Assertions.*;
import static baseball.input.InputErrorEnum.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class InputValidatorTest {
    private final InputValidator inputValidator = new InputValidator();

    @Test
    @DisplayName("중복체크 테스트")
    void hasDuplicateNumberTest() {
        String duplicateInput = "221";
        assertThatThrownBy(()-> {
            inputValidator.validateInput(duplicateInput);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE.text());
    }

    @Test
    @DisplayName("숫자체크 테스트")
    void isInputNumberTest() {
        String stringInput = "ㅋ1ㅋ";
        String negativeInput = "-13";
        assertThatThrownBy(()-> {
            inputValidator.validateInput(stringInput);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_NUMERIC.text());
        assertThatThrownBy(()-> {
            inputValidator.validateInput(negativeInput);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_NUMERIC.text());
    }

    @Test
    @DisplayName("세자리체크 테스트")
    void isInputThreeDigitsTest() {
        String badInput = "2212";
        assertThatThrownBy(()-> {
            inputValidator.validateInput(badInput);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_THREE_DIGITS.text());
    }

    @Test
    @DisplayName("중복체크 테스트")
    void alreadyCheckedTest() {
        String input = "123";
        assertThatThrownBy(()-> {
            inputValidator.validateInput(input);
            inputValidator.validateInput(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ALREADY_CHECKED.text());
    }
}