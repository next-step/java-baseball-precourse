package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallTest {
    private Ball ball;

    @BeforeEach
    void setUp() {
        ball = new Ball(0, 2);
    }

    @Test
    void 스트라이크_판단() {
        BallStatus status = ball.compare(new Ball(0, 2));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void 볼_판단() {
        BallStatus status = ball.compare(new Ball(1, 2));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void 낫싱_판단() {
        BallStatus status = ball.compare(new Ball(2, 1));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
