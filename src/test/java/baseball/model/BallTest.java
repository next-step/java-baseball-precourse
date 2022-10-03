package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallTest {

	private Ball computer;

	@BeforeEach
	void setUp() {
		computer = new Ball(1, 7);
	}

	@Test
	@DisplayName("숫자 위치와 값이 같으면 스트라이크를 반환한다.")
	void strike() {
		Ball userBall = new Ball(1, 7);
		BallStatus status = computer.play(userBall);
		assertThat(status).isEqualTo(BallStatus.STRIKE);
	}

	@Test
	@DisplayName("숫자 위치가 다르고 값이 같으면 볼을 반환한다.")
	void ball() {
		Ball userBall = new Ball(2, 7);
		BallStatus status = computer.play(userBall);
		assertThat(status).isEqualTo(BallStatus.BALL);
	}

	@Test
	@DisplayName("값이 다르면 낫싱을 반환한다.")
	void nothing() {
		Ball userBall = new Ball(2, 6);
		BallStatus status = computer.play(userBall);
		assertThat(status).isEqualTo(BallStatus.NOTHING);
	}

}