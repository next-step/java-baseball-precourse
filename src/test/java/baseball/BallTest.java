package baseball;

import baseball.balls.Ball;
import baseball.balls.BallStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallTest {

    private Ball com;

    @BeforeEach
    void setUp() {
        com = new Ball(1, 4);
    }

    @Test
    @DisplayName("낫싱 - 일치하는 숫자가 없는 경우")
    void test01() {
        BallStatus status = com.play(new Ball(2, 5));
        Assertions.assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    @DisplayName("볼 - 숫자는 같지만 입력 위치가 다른 경우")
    void test02() {
        BallStatus status = com.play(new Ball(2, 4));
        Assertions.assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("스트라이크 - 숫자와 입력 위치가 같은 경우")
    void test03() {
        BallStatus status = com.play(new Ball(1, 4));
        Assertions.assertThat(status).isEqualTo(BallStatus.STRIKE);
    }
}
