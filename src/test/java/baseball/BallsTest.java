package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        Status status = this.balls.playBall(Ball.of(1, 0));
        assertThat(status).isEqualTo(Status.STRIKE);

    }

    @Test
    void BallsPlayBall() {
        List<Ball> ballList = new ArrayList<>();
        Status status = this.balls.playBall(Ball.of(1, 1));
        assertThat(status).isEqualTo(Status.BALL);

    }

    @Test
    void BallsPlayNothing() {
        Status status = this.balls.playBall(Ball.of(4, 0));
        assertThat(status).isEqualTo(Status.NOTHING);

    }

    @Test
    void playerBalseBallInit() {
        List<Ball> ballPlayer = Balls.playerBallInit("123");
        for (int i = 0; i < ballPlayer.size(); i++) {
            assertThat(ballPlayer.get(i).isBallNumber(i + 1)).isTrue();
        }
    }

    @Test
    void playBall() {
        Balls balls = Balls.of();
        List<Ball> ballPlayer = Balls.playerBallInit("123");

        PlayResult playResult = balls.playBalls(ballPlayer);

        System.out.println("STRIKE:" + playResult.strikeCount());
        for (Map.Entry<Status, Integer> entry : playResult.resultGame().entrySet()) {
            System.out.print(entry.getValue() + "" + entry.getKey().statusName + " ");
        }
    }
}