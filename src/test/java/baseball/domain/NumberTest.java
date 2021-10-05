package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import baseball.exception.InvalidNumberRangeException;
import nextstep.utils.Randoms;

class NumberTest {
	@RepeatedTest(1_000)
	@DisplayName("1~9 범위의 숫자, 0~2 범위를 지닌 자릿 수를 숫자 객체가 생성되는지")
	void create() {
		// given
		int value = Randoms.pickNumberInRange(Number.MIN, Number.MAX);

		// when
		Number number = new Number(value);

		// then
		assertThat(number)
			.isNotNull()
			.isEqualTo(new Number(value));
	}

	@Test
	@DisplayName("허용된 값이 초과할 경우 InvalidNumberRangeException 예외가 발생한다.")
	void create_should_throw_exception_when_invalid_value() {
		// given

		// when
		int value = Number.MAX + 1;

		// then
		assertThatThrownBy(() -> new Number(value))
			.isInstanceOf(InvalidNumberRangeException.class)
			.hasMessage("Each number(%d) has exceeded the allowed number range.", value);
	}
}