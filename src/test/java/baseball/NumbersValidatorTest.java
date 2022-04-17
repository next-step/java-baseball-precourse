package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import baseball.domain.validator.NumbersValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NumbersValidatorTest {

    @DisplayName("숫자로된 문자열이 정상적일 경우 True를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"132:3", "352:3", "384:3"}, delimiter = ':')
    void isNumbersValidate_P01(String input, int size) {
        assertThat(NumbersValidator.isNumbersValidate(input, size)).isTrue();
    }

    @DisplayName("문자열에 숫자가 아닌 값이 있을 경우 에러를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1a2:3", "a52:3", "84a:3"}, delimiter = ':')
    void isNumbersValidate_N01(String input, int size) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> NumbersValidator.isNumbersValidate(input, size));
    }

    @DisplayName("문자열에 1-9가아닌 숫자가 있을 경우 에러를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"102:3", "052:3", "840:3"}, delimiter = ':')
    void isNumbersValidate_N02(String input, int size) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> NumbersValidator.isNumbersValidate(input, size));
    }

    @DisplayName("문자열의 원소에 중복된 숫자가 있을 경우 에러를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"112:3", "022:3", "040:3"}, delimiter = ':')
    void isNumbersValidate_N03(String input, int size) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> NumbersValidator.isNumbersValidate(input, size));
    }
}
