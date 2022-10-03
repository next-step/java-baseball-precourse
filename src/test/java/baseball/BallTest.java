package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import baseball.domain.Ball;
import baseball.domain.Status;

public class BallTest {
	private static Ball ball;

	@BeforeAll
	static void beforeAll() {
		ball = new Ball(1,2);
	}

	@Test
	void compareBallTest() {
		assertThat(ball.compareBall(Arrays.asList(
			new Ball(1, 0),
			new Ball(3, 1),
			new Ball(4, 2)))).isEqualTo(Status.BALL);
		assertThat(ball.compareBall(Arrays.asList(
			new Ball(6, 0),
			new Ball(4, 1),
			new Ball(1, 2)))).isEqualTo(Status.STRIKE);
		assertThat(ball.compareBall(Arrays.asList(
			new Ball(8, 0),
			new Ball(5, 1),
			new Ball(9, 2)))).isEqualTo(Status.NOTHING);
	}
}
