package baseball.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BallPositionTest {

	@DisplayName("BallPosition 객체를 생성한다.")
	@ParameterizedTest(name = "{displayName} / input = {0}")
	@ValueSource(ints = {1, 3})
	void create(int input) {
		// given
		final BallPosition ballPosition = new BallPosition(input);

		// when then
		assertEquals(new BallPosition(input), ballPosition);
	}

	@DisplayName("올바르지 않은 input을 가진 BallPosition 객체를 생성한다.")
	@ParameterizedTest(name = "{displayName} / input = {0}")
	@ValueSource(ints = {0, 4})
	void create_with_invalid_number(int input) {
		// given: none

		// when then
		assertThatThrownBy(() -> new BallPosition(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR] 공의 위치는 1-3 까지만 가능합니다.");
	}
}
