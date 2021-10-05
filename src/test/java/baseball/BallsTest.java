package baseball;

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
        Status status = balls.playBall(Ball.of(1, 0));
        assertThat(status).isEqualTo(Status.STRIKE);

    }

    @Test
    void BallsPlayBall() {
        Status status = balls.playBall(Ball.of(1, 1));
        assertThat(status).isEqualTo(Status.BALL);

    }

    @Test
    void BallsPlayNothing() {
        Status status = balls.playBall(Ball.of(4, 0));
        assertThat(status).isEqualTo(Status.NOTHING);

    }

    @Test
    void playerBalseBallInit() {
        List<Ball> ballPlayer = Balls.playerBallInit("123");
        for (int i = 0; i < ballPlayer.size(); i++) {
            assertThat(ballPlayer.get(i).matchBallNumber(i + 1)).isTrue();
        }
    }

    @Test
    void playerBalseBallInit2() {
        List<Ball> ballPlayer = Balls.playerBallInit("123");
        System.out.println(ballPlayer.get(0).matchBallNumber(1));
    }
}