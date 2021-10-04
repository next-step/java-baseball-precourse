package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class BallPositionTest {

    @Test
    @DisplayName("BallPosition 객체를 생성하여 객체를 비교한다")
    void create() {
        BallPosition ballPosition = new BallPosition(2);
        assertThat(ballPosition).isEqualTo(new BallPosition(2));
    }

    @Test
    @DisplayName("위치는 0, 1, 2만 가능하다. 경계값 3")
    void 위치는_3개만_가능() {
        assertThatThrownBy(() -> {
            BallPosition ballPosition = new BallPosition(3);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리 까지만 가능");

    }
}