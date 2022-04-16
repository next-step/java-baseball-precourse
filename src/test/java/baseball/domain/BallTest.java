package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallTest {
    @DisplayName("1보다 작은 숫자 입력")
    @Test
    void lessthan1() {
        assertThatThrownBy(() -> new Ball(0))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("9보다 큰 숫자 입력")
    @Test
    void greaterthan9() {
        assertThatThrownBy(() -> new Ball(10))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("허용 범위의 볼 생성")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void normal(int number) {
        Ball ball = new Ball(number);
        assertThat(ball.getNumber()).isEqualTo(number);
    }
}