package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {
    private Ball computerBall;

    @BeforeEach
    void init() {
        computerBall = new Ball(1, 1);
    }

    @Test
    @DisplayName("스트라이크_확인")
    void 스트라이크_확인() {
        BallStatus state = computerBall.play(new Ball(1, 1));
        assertThat(state).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("볼_확인")
    void 볼_확인() {
        BallStatus state = computerBall.play(new Ball(2, 1));
        assertThat(state).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("낫싱_확인")
    void 낫싱_확인() {
        BallStatus state = computerBall.play(new Ball(2, 2));
        assertThat(state).isEqualTo(BallStatus.NOTHING);
    }
}
