package baseball.ball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author KingCjy
 */
public class BallTest {

    @Test
    @DisplayName("다른 Ball클래스와 비교해 볼카운트를 리턴한다. 3스트라이크")
    public void judgeBallCountTest() {
        int[] numbers = {2, 1, 7};
        Ball ball = new Ball(numbers);
        Ball other = new Ball(numbers);

        BallCount ballCount = ball.judgeBallCount(other);
        assertThat(ballCount.isFinish()).isTrue();
    }

    @Test
    @DisplayName("다른 Ball클래스와 비교해 볼카운트를 리턴한다. 1스트라이크 2볼")
    public void judgeBallCountTest2() {
        Ball ball = new Ball(new int[]{9, 7, 3});
        Ball other = new Ball(new int[]{9, 3, 7});

        BallCount ballCount = ball.judgeBallCount(other);

        assertThat(ballCount.isFinish()).isFalse();
        assertThat(ballCount).isEqualTo(new BallCount(Arrays.asList(Score.STRIKE, Score.BALL, Score.BALL)));
    }

    @Test
    @DisplayName("다른 Ball클래스와 비교해 볼카운트를 리턴한다. 3낫싱")
    public void judgeBallCountTest3() {
        Ball ball = new Ball(new int[]{4, 3, 2});
        Ball other = new Ball(new int[]{5, 6, 7});

        BallCount ballCount = ball.judgeBallCount(other);

        assertThat(ballCount.isFinish()).isFalse();
        assertThat(ballCount).isEqualTo(new BallCount(Arrays.asList(Score.NOTHING, Score.NOTHING, Score.NOTHING)));
    }

}
