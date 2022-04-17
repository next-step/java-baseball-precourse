package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import baseball.domain.game.GameRule;
import baseball.domain.validator.NumbersValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NumbersValidatorTest {
    NumbersValidator numbersValidator;
    GameRule gameRule;

    @BeforeEach
    void before() {
        gameRule = new GameRule(1, 9, 3);
        numbersValidator = new NumbersValidator(gameRule);
    }

    @DisplayName("숫자로된 문자열이 정상적일 경우 True를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"132", "352", "384"})
    void isNumbersValidate_P01(String input) {
        assertThat(numbersValidator.isNumbersValidate(input)).isTrue();
    }

    @DisplayName("문자열의 길이가 정한 크기로 안 들어올 경우 에러를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1124"})
    void isNumbersValidate_N01(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> numbersValidator.isNumbersValidate(input));
    }

    @DisplayName("문자열이 빈값일 경우 에러를 반환한다.")
    @Test
    void isNumbersValidate_N02() {
        String input = "";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> numbersValidator.isNumbersValidate(input));
    }

    @DisplayName("문자열에 숫자가 아닌 값이 있을 경우 에러를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1a2", "a52", "84a"})
    void isNumbersValidate_N03(String input) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> numbersValidator.isNumbersValidate(input));
    }

    @DisplayName("문자열에 1-9가아닌 숫자가 있을 경우 에러를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"102", "052", "840"})
    void isNumbersValidate_N04(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> numbersValidator.isNumbersValidate(input));
    }

    @DisplayName("문자열의 원소에 중복된 숫자가 있을 경우 에러를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"112", "022", "040"})
    void isNumbersValidate_N05(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> numbersValidator.isNumbersValidate(input));
    }

}
