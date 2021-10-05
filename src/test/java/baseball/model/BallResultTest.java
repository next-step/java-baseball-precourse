package baseball.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallResultTest {

	@DisplayName("BallResult 객체를 생성한다.")
	@Test
	void create() {
		// given
		final BallResult ballResult = new BallResult();

		// when then
		assertEquals(new BallResult(0), ballResult);
	}

	@DisplayName("올바르지 않은 input 을 가진 BallResult 객체를 생성한다.")
	@ParameterizedTest(name = "{displayName} : {0}")
	@ValueSource(ints = {-1, 4})
	void create_fail_test(int input) {
		// given:none

		// when then
		assertThatThrownBy(() -> new BallResult(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR] ball 이 될 수 있는 값은 0-3 범위 내여야 합니다.");
	}

	@DisplayName("increase 한 경우, ball 갯수가 한개 증가한 BallResult 객체를 반환한다.")
	@Test
	void increase() {
		// given
		final BallResult ballResult = new BallResult();

		// when then
		assertEquals(new BallResult(1), ballResult.increase());
	}

	@DisplayName("increase 한 경우, 4 이상의 ball 이 되면 에러를 발생시킨다.")
	@Test
	void increase_fail_test() {
		// given
		final BallResult ballResult = new BallResult(3);

		// when then
		assertThatThrownBy(ballResult::increase)
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR] ball 이 될 수 있는 값은 0-3 범위 내여야 합니다.");
	}
}
