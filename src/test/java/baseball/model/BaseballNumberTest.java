package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void 숫자_범위는_0보다_크고_10보다_작다_성공(int number) {
        BaseballNumber baseballNumber = new BaseballNumber(number);

        assertThat(baseballNumber.getNumber()).isEqualTo(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 10})
    void 숫자_범위는_0보다_크고_10보다_작다_예외(int number) {
        assertThatThrownBy(() -> {
            new BaseballNumber(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}