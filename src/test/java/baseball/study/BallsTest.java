package baseball.study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.BallStatus;
import study.baseball.Ball;
import study.baseball.Balls;
import study.baseball.PlayResult;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    private Balls answers;

    @BeforeEach
    void setUp() {
        answers = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    void nothing() {
        BallStatus status = answers.play(new Ball(1,4));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void ball() {
        BallStatus status = answers.play(new Ball(1,2));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void strike() {
        BallStatus status = answers.play(new Ball(1,1));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void play_nothing() {
        PlayResult result = answers.play(Arrays.asList(4, 5, 6));
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    void play_1strike_1ball() {
        PlayResult result = answers.play(Arrays.asList(1, 4, 2));
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    void play_3strike() {
        PlayResult result = answers.play(Arrays.asList(1, 2, 3));
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
        // 객체의 필드에 직접 접근해서 가져오지 말고 객체에 필드를 달라고 메세지를 보내자!
    }
}
