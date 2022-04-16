package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CompareResultTest {
    @DisplayName("볼과 스트라이크가 0인 경우, 낫싱")
    @Test
    void nothing() {
        assertThat(new CompareResult(0, 0).isNothing()).isTrue();
    }

    @DisplayName("볼이나 스트라이크가 있는 경우 낫싱이 아님")
    @ParameterizedTest
    @CsvSource(value = {"0,1", "1,0", "1,1"})
    void notNothing(int ball, int strike) {
        assertThat(new CompareResult(ball, strike).isNothing())
                .isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void getBall(int ball) {
        assertThat(new CompareResult(ball, 0).getBall()).isEqualTo(ball);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void getStrike(int strike) {
        assertThat(new CompareResult(0, strike).getStrike()).isEqualTo(strike);
    }
}