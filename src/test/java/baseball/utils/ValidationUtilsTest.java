package baseball.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author KingCjy
 */
class ValidationUtilsTest {

    @Test
    @DisplayName("잘못된 입력(3자리이상의 숫자) 가 들어올 경우 Validation.BALL_INVALID_LENGTH 리턴")
    public void isValidBallInputTest() {
        ValidationResult result = ValidationUtils.isValidBallInput("1234");
        assertThat(result).isEqualTo(ValidationResult.BALL_INVALID_LENGTH);
    }

    @Test
    @DisplayName("잘못된 입력(문자) 가 들어올 경우 Validation.BALL_IS_NOT_NUMBER 리턴")
    public void isValidBallInputTest2() {
        ValidationResult result = ValidationUtils.isValidBallInput("가나다");
        assertThat(result).isEqualTo(ValidationResult.BALL_IS_NOT_NUMBER);
    }

    @Test
    @DisplayName("잘못된 입력(중복된 숫자) 가 들어올 경우 Validation.BALL_DUPLICATED_NUMBER 리턴")
    public void isValidBallInputTest3() {
        ValidationResult result = ValidationUtils.isValidBallInput("112");
        assertThat(result).isEqualTo(ValidationResult.BALL_DUPLICATED_NUMBER);
    }

    @ParameterizedTest
    @DisplayName("잘못된 입력(1, 2이외의 다른 입력) 가 들어올 경우 Validation.BALL_DUPLICATED_NUMBER 리턴")
    @ValueSource(strings = {"3", "가나다", "123"})
    public void isValidRestartInputTest(String input) {
        ValidationResult result = ValidationUtils.isValidRestartInput(input);
        assertThat(result).isEqualTo(ValidationResult.RESTART_INVALID);
    }
}