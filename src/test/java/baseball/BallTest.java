package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("공끼리 비교하는 테스트")
public class BallTest {

	private Ball ball;

	@BeforeEach
	void setUp() {
		ball = new Ball(1, 0);
	}

	@Test
	@DisplayName("스트라이크")
	void 스트라이크() {
		Ball userBall = new Ball(1, 0);
		assertThat(ball.match(userBall)).isEqualTo(BallStatus.STRIKE);
	}

	@Test
	@DisplayName("볼")
	void 볼() {
		Ball userBall = new Ball(1, 1);
		assertThat(ball.match(userBall)).isEqualTo(BallStatus.BALL);
	}

	@Test
	@DisplayName("낫싱")
	void 낫싱() {
		Ball userBall = new Ball(2, 0);
		assertThat(ball.match(userBall)).isEqualTo(BallStatus.NOTHING);
	}
}
