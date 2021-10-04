package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallNumberTest {

    @Test
    @DisplayName("BallNumber 객체를 생성하여 객체를 비교한다")
    void create() {
        BallNumber ballNumber = new BallNumber(9);
        assertThat(ballNumber).isEqualTo(new BallNumber(9));
    }

    @DisplayName("값은 1~9까지만 가능하다. 경계값 0, 10")
    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void 값은_0부터_9까지만_가능(int testNumber) {
        assertThatThrownBy(() -> {
            BallNumber ballNumber = new BallNumber(testNumber);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1~9까지만 허용");

    }

}