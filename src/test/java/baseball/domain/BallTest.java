package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    @Test
    @DisplayName("스트라이크 : 같은 수 같은 자리")
    void 스트라이크() {
        Ball ball = new Ball(1, 3);
        Ball other = new Ball(1, 3);
        BallStatus ballStatus = ball.play(other);
        assertThat(ballStatus).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("볼 : 같은 수 다른 자리")
    void 볼() {
        Ball ball = new Ball(1, 3);
        Ball other = new Ball(0, 3);
        BallStatus ballStatus = ball.play(other);
        assertThat(ballStatus).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("낫싱 : 스트라이크, 볼이 전혀 없음")
    void 낫싱() {
        Ball ball = new Ball(1, 3);
        Ball other = new Ball(0, 2);
        BallStatus ballStatus = ball.play(other);
        assertThat(ballStatus).isEqualTo(BallStatus.NOTHING);
    }
}
