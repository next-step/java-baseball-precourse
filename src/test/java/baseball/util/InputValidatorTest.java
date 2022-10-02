package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    @DisplayName("정답값은 숫자만 가능하다")
    void test() {
        String notNumericInput = "숫자아님";
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateGuessNumber(notNumericInput);
        });
    }

    @Test
    @DisplayName("정답값은 게임 사이즈와 같아야한다")
    void test2() {
        String tooLongInput = "12345";
        String tooShortInput = "12";
        String goodInput = "123";

        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateGuessNumber(tooLongInput);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateGuessNumber(tooShortInput);
        });
        assertDoesNotThrow(() -> {
                    InputValidator.validateGuessNumber(goodInput);
                }
        );
    }

    @Test
    @DisplayName("정답값은 중복되지않아야 한다")
    void test3() {
        String duplicatedInput = "111";
        String notDuplicatedInput = "123";
        assertThrows(IllegalArgumentException.class, () -> {
           InputValidator.validateRestartInput(duplicatedInput);
        });

        assertDoesNotThrow(() -> {
                    InputValidator.validateGuessNumber(notDuplicatedInput);
                }
        );
    }

    @Test
    @DisplayName("다시시작 입력값은 숫자만 가능하다")
    void test4() {
        String notNumericInput = "숫자아님";
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateRestartInput(notNumericInput);
        });
    }

    @Test
    @DisplayName("다시시작 입력값은 1, 2만 입력가능하다")
    void test5() {
        String invalidRangeInput = "3";
        String validRangeInput = "1";
        String validRangeInput2 = "2";

        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateRestartInput(invalidRangeInput);
        });

        assertDoesNotThrow(() -> {
                    InputValidator.validateRestartInput(validRangeInput);
                }
        );
        assertDoesNotThrow(() -> {
                    InputValidator.validateRestartInput(validRangeInput2);
                }
        );
    }


}