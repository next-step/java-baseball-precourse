package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("3개의 볼을 비교하는 테스트")
class BallsTest {

	private Balls balls;

	@BeforeEach
	void setUp() {
		balls = new Balls(Arrays.asList(1, 2, 3));
	}

	@Test
	@DisplayName("3스트라이크")
	void _3_스트라이크() {
		Balls userBalls = new Balls(Arrays.asList(1, 2, 3));
		GameResult gameResult = balls.play(userBalls);
		assertGameResult(gameResult, true, "3스트라이크");
	}

	@Test
	@DisplayName("1스트라이크 2볼")
	void _1_스트라이크_2볼() {
		Balls userBalls = new Balls(Arrays.asList(1, 3, 2));
		GameResult gameResult = balls.play(userBalls);
		assertGameResult(gameResult, false, "1스트라이크 2볼");
	}

	@Test
	@DisplayName("3볼")
	void _3볼() {
		Balls userBalls = new Balls(Arrays.asList(3, 1, 2));
		GameResult gameResult = balls.play(userBalls);
		assertGameResult(gameResult, false, "3볼");
	}

	@Test
	@DisplayName("낫싱")
	void 낫싱() {
		Balls userBalls = new Balls(Arrays.asList(4, 5, 6));
		GameResult gameResult = balls.play(userBalls);
		assertGameResult(gameResult, false, "낫싱");
	}

	private void assertGameResult(GameResult gameResult, boolean isComplete, String message) {
		assertThat(gameResult.isComplete()).isEqualTo(isComplete);
		assertThat(gameResult.toString()).isEqualTo(message);
	}
}
