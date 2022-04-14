package baseball;

import baseball.balls.Ball;
import baseball.balls.BallStatus;
import baseball.balls.Balls;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class BallsTest {

    private Balls balls;

    @BeforeEach
    void setUp() {
        balls = new Balls(Arrays.asList(1, 4, 5));
    }

    @Test
    @DisplayName("낫싱 - 일치하는 숫자가 없는 경우")
    void test01() {
        BallStatus status = balls.play(new Ball(0, 3));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    @DisplayName("볼 - 숫자는 같지만 입력 위치가 다른 경우")
    void test02() {
        BallStatus status = balls.play(new Ball(0, 4));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("스트라이크 - 숫자와 입력 위치가 같은 경우")
    void test03() {
        BallStatus status = balls.play(new Ball(0, 1));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }
}
