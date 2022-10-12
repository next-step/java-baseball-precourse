package baseball.study;

import org.junit.jupiter.api.BeforeEach;
import study.BallStatus;
import study.baseball.Ball;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BallTest {

    private Ball com;

    @BeforeEach
    void setUp() {
        com = new Ball(1, 4);
    }

    @Test
    void nothing() {
        BallStatus status = com.play(new Ball(2,5));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void ball() {
        BallStatus status = com.play(new Ball(2,4));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void strike() {
        BallStatus status = com.play(new Ball(1,4));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

}
