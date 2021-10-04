package baseball.referee;

import baseball.balls.Ball;
import baseball.balls.Balls;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {

    private Balls computerBalls;

    @BeforeEach
    public void setUP() {
        Ball firstBall = new Ball(1,2);
        Ball secondBall = new Ball(2,4);
        Ball thirdBall = new Ball(3,6);

        computerBalls = new Balls(Arrays.asList(firstBall,secondBall,thirdBall));
    }

    @Test
    @DisplayName("정답과 사용자의 공을 비교하여 같은 위치에 같은 숫자일 경우 STRIKE 리턴")
    public void isStrike() {
        Ball userBall = new Ball(1, 2);

        Referee referee = new Referee(computerBalls);

        String refereeResult = referee.judge(userBall);

        assertThat(refereeResult).isEqualTo("STRIKE");
    }

    @Test
    @DisplayName("정답과 사용자의 공을 비교하여 다른 위치에 같은 숫자일 경우 BALL 리턴")
    public void isBall() {
        Ball userBall = new Ball(1, 4);

        Referee referee = new Referee(computerBalls);

        String refereeResult = referee.judge(userBall);

        assertThat(refereeResult).isEqualTo("BALL");
    }

    @Test
    @DisplayName("정답에 일치하는 숫자가 사용자 공에 없다면 NOTHING 리턴")
    public void isNothing() {
        Ball userBall = new Ball(2, 8);

        Referee referee = new Referee(computerBalls);

        String refereeResult = referee.judge(userBall);

        assertThat(refereeResult).isEqualTo("NOTHING");
    }

}
