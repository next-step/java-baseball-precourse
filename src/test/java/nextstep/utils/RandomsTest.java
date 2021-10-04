package nextstep.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomsTest {
	@DisplayName("랜덤 값의 범위 유효를 확인한다.")
	@Test
	void given_two_number_then_check_range() {
		int number = Randoms.pickNumberInRange(1, 5);
		Assertions.assertThat(number)
			.isBetween(1, 5);
	}

	@DisplayName("끝값의 범위 초과 예외를 확인한다.")
	@Test
	void when_end_value_is_max_then_throw_exception() {
		Assertions.assertThatIllegalArgumentException()
			.isThrownBy(() -> Randoms.pickNumberInRange(1, Integer.MAX_VALUE))
			.withMessage("끝값이 너무 큽니다. (스택 오버플로우 발생이 가능합니다)");
	}

	@DisplayName("끝값보다 첫번째 값이 큰 경우 예외를 확인한다.")
	@Test
	void when_start_greater_than_end_then_throw_exception() {
		Assertions.assertThatIllegalArgumentException()
			.isThrownBy(() -> Randoms.pickNumberInRange(10, 1))
			.withMessage("startInclusive가 endInclusive보다 클 수 없습니다.");
	}

	@DisplayName("입력 값이 너무 큰 경우 예외를 발생한다.")
	@Test
	void when_too_large_value_then_throw_exception() {
		Assertions.assertThatIllegalArgumentException()
			.isThrownBy(() -> Randoms.pickNumberInRange(1, Integer.MAX_VALUE + 1))
			.withMessage("입력값이 너무 큽니다.");
	}
}