package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    private final Ball ball = new Ball(1, 2);

    @Test
    @DisplayName("위치 값과 숫자가 맞으면 스트라이크")
    void strike() {
        BallStatus status = ball.play(new Ball(1, 2));

        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("위치 값은 다르고 숫자만 맞으면 볼")
    void ball() {
        BallStatus status = ball.play(new Ball(2, 2));

        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("위치 값과 숫자가 전부 다르면 낫싱")
    void nothing() {
        BallStatus status = ball.play(new Ball(2, 3));

        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
