package baseball.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import baseball.exception.DigitRangeOverException;
import baseball.exception.InvalidNumberRangeException;
import nextstep.utils.Randoms;

class NumberTest {

	@RepeatedTest(1_000)
	@DisplayName("1~9 범위의 숫자, 0~2 범위를 지닌 자릿 수를 숫자 객체가 생성되는지")
	void create() {
		// given
		int value = Randoms.pickNumberInRange(Number.MIN_OF_VALUE, Number.MAX_OF_VALUE);
		int digit = Randoms.pickNumberInRange(Number.MIN_OF_DIGIT, Number.MAX_OF_DIGIT);

		// when
		Number number = new Number(value, digit);

		// then
		assertThat(number)
			.isNotNull()
			.isEqualTo(new Number(value, digit));
	}

	@Test
	@DisplayName("허용된 값이 초과할 경우 InvalidNumberRangeException 예외가 발생한다.")
	void create_should_throw_exception_when_invalid_value() {
		// given
		int digit = Randoms.pickNumberInRange(Number.MIN_OF_DIGIT, Number.MAX_OF_DIGIT);

		// when
		int value = Number.MAX_OF_VALUE + 1;

		// then
		assertThatThrownBy(() -> new Number(value, digit))
			.isInstanceOf(InvalidNumberRangeException.class)
			.hasMessage("Each number(%d) has exceeded the allowed number range.", value);
	}

	@Test
	@DisplayName("혀용된 자릿수가 초과할 경우 DigitRangeOverException 예외가 발생된다.")
	void create_should_throw_exception_when_invalid_digit() {
		// given
		int value = Randoms.pickNumberInRange(Number.MIN_OF_VALUE, Number.MAX_OF_VALUE);

		// when
		int digit = Number.MAX_OF_DIGIT + 1;

		// then
		assertThatThrownBy(() -> new Number(value, digit))
			.isInstanceOf(DigitRangeOverException.class)
			.hasMessage("You have exceeded the number of digits.");
	}
}