package baseball.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BallNumberTest {

	@DisplayName("BallNumber 객체를 생성한다.")
	@ParameterizedTest(name = "{displayName} / input = {0}")
	@ValueSource(ints = {1, 9})
	void create(int input) {
		// given
		final BallNumber ballNumber = new BallNumber(input);

		// when then
		assertEquals(new BallNumber(input), ballNumber);
	}

	@DisplayName("올바르지 않은 input을 가진 BallNumber 객체를 생성한다.")
	@ParameterizedTest(name = "{displayName} / input = {0}")
	@ValueSource(ints = {0, 10})
	void create_with_invalid_number(int input) {
		// given: none

		// when then
		assertThatThrownBy(() -> new BallNumber(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR] 1-9 까지의 숫자만 입력가능합니다.");
	}
}
