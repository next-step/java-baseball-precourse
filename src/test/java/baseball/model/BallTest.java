package baseball.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallTest {

	private Ball computerBall;

	@BeforeEach
	void setUp() {
		computerBall = new Ball(1, 1);
	}

	@DisplayName("ball 의 숫자가 다른경우, Nothing 을 반환한다.")
	@Test
	void nothing() {
		// given
		final Ball playerBall = new Ball(2, 1);

		// when then
		assertEquals(GameStatus.NOTHING, computerBall.play(playerBall));
	}

	@DisplayName("ball 의 숫자는 같지만 위치가 다른경우, Ball 을 반환한다.")
	@Test
	void ball() {
		// given
		final Ball playerBall = new Ball(1, 2);

		// when then
		assertEquals(GameStatus.BALL, computerBall.play(playerBall));
	}

	@DisplayName("ball 의 숫자가 같으며, 위치도 같은경우 Strike 를 반환한다.")
	@Test
	void strike() {
		// given
		final Ball playerBall = new Ball(1, 1);

		// when then
		assertEquals(GameStatus.STRIKE, computerBall.play(playerBall));
	}
}
