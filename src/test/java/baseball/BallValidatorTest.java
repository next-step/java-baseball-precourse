package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class BallValidatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1:false", "a13:false","012:false", "111:false", "1234:false", "123:true"}, delimiter = ':')
    @DisplayName("input 값이 적절한지 검증하는 기능에 대한 테스트")
    void isValidInput(String input, boolean expected) {
        assertThat(BallValidator.isValidBalls(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:false", "123:true","1234:false"}, delimiter = ':')
    @DisplayName("값의 자리수가 세자리인지 검증하는 기능에 대한 테스트")
    void isInputHasRightLength(String input, boolean expected) {
        assertThat(BallValidator.isInputHasRightLength(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"000:false", "111:true","11a:false","aaa:false"}, delimiter = ':')
    @DisplayName("값이 1부터 9까지의 숫자로만 이루어져 있는지 검증하는 기능에 대한 테스트")
    void isInputContainsOnlyOneToNine(String input, boolean expected) {
        assertThat(BallValidator.isInputContainsOnlyOneToNine(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"123:true", "112:false", "111:false"}, delimiter = ':')
    @DisplayName("값이 서로 다른 수로 이루어져 있는지 검증하는 기능에 대한 테스트")
    void isInputContainsUniqueNumbers(String input, boolean expected) {
        assertThat(BallValidator.isInputContainsUniqueNumbers(input)).isEqualTo(expected);
    }
}