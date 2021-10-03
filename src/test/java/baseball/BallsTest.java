package baseball;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

class BallsTest {

    private Balls balls;


    @BeforeEach
    void setUp() {
        balls = Balls.of();
    }

    @Test
    void BallsPlayStrike() {
        List<Ball> ballList = new ArrayList<>();
        Status status = this.balls.playBall(Ball.of(1,0));
        assertThat(status).isEqualTo(Status.STRIKE);

    }
    @Test
    void BallsPlayBall() {
        List<Ball> ballList = new ArrayList<>();
        Status status = this.balls.playBall(Ball.of(1,1));
        assertThat(status).isEqualTo(Status.BALL);

    }    @Test
    void BallsPlayNothing() {
        List<Ball> ballList = new ArrayList<>();
        Status status = this.balls.playBall(Ball.of(4,0));
        assertThat(status).isEqualTo(Status.NOTHING);

    }

}