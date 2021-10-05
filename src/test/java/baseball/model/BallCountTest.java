package baseball.model;

import static baseball.model.BallStatus.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("볼 카운트 테스트")
class BallCountTest {

	@DisplayName("3스트라이크")
	@Test
	void three_strike() {
		final BallCount ballCount = BallCount.from(Arrays.asList(STRIKE, STRIKE, STRIKE));

		assertThat(ballCount.countStrike()).isEqualTo(3);
	}

	@DisplayName("1스트라이크 1볼")
	@Test
	void one_strike_one_ball() {
		final BallCount ballCount = BallCount.from(Arrays.asList(STRIKE, BALL, NOTHING));

		assertThat(ballCount.countStrike()).isEqualTo(1);
		assertThat(ballCount.countBall()).isEqualTo(1);
	}

	@DisplayName("볼 카운트의 개수가 3개가 아니면 예외발생")
	@Test
	void ball_count_size_exception() {
		final String ERROR_MESSAGE = "볼 카운트의 개수는 3개여야 합니다.";

		assertThatThrownBy(() -> BallCount.from(Collections.singletonList(STRIKE)))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ERROR_MESSAGE);

		assertThatThrownBy(() -> BallCount.from(Arrays.asList(STRIKE, STRIKE)))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ERROR_MESSAGE);

		assertThatThrownBy(() -> BallCount.from(Arrays.asList(STRIKE, STRIKE, BALL, NOTHING)))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ERROR_MESSAGE);
	}
}