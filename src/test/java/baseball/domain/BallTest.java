package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallTest {

    private Ball ball;

    @BeforeEach
    void setUp() {
        ball = new Ball(0, 1);
    }

    @Test
    @DisplayName("Ball 객체를 생성하여 객체를 비교한다")
    void create() {
        assertThat(ball).isEqualTo(new Ball(0, 1));
    }

    @Test
    @DisplayName("두개의 Ball을 비교하여 스트라이크인지 확인한다")
    void 스트라이크() {
        assertThat(ball.compare(new Ball(0, 1))).isEqualTo(BallHint.STRIKE);
    }

    @Test
    @DisplayName("두개의 Ball을 비교하여 볼인지 확인한다")
    void 볼() {
        assertThat(ball.compare(new Ball(1, 1))).isEqualTo(BallHint.BALL);
    }

    @Test
    @DisplayName("두개의 Ball을 비교하여 낫싱인지 확인한다")
    void 낫싱() {
        assertThat(ball.compare(new Ball(1, 2))).isEqualTo(BallHint.NOTHING);
    }
}