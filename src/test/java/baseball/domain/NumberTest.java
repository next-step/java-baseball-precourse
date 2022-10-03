package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

    @DisplayName("숫자는 1에서 9사이의 값을 갖는다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void numberRange(int number) {
        assertThat(Number.from(number)).isInstanceOf(Number.class);
    }

    @DisplayName("1에서 9사이 이외의 값을 입력하면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-2, -1, 0, 10, 11, 12})
    void numberOutOfRange(int number) {
        assertThatThrownBy(() -> Number.from(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 같으면 참이다.")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "3:3", "6:6", "9:9"}, delimiter = ':')
    void numberSame(int input1, int input2) {
        Number number1 = Number.from(input1);
        Number number2 = Number.from(input2);
        assertThat(number1).isEqualTo(number2);
    }

    @DisplayName("숫자가 다르면 거짓이다.")
    @ParameterizedTest
    @CsvSource(value = {"1:3", "3:1", "6:9", "9:7"}, delimiter = ':')
    void numberDifferent(int input1, int input2) {
        Number number1 = Number.from(input1);
        Number number2 = Number.from(input2);
        assertThat(number1).isNotEqualTo(number2);
    }
}
