package baseball.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class StrikeResultTest {

	@DisplayName("StrikeResult 객체를 생성한다.")
	@Test
	void create() {
		// given
		final StrikeResult strikeResult = new StrikeResult();

		// when then
		assertEquals(new StrikeResult(0), strikeResult);
	}

	@DisplayName("올바르지 않은 input 을 가진 StrikeResult 객체를 생성한다.")
	@ParameterizedTest(name = "{displayName} : {0}")
	@ValueSource(ints = {-1, 4})
	void create_fail_test(int input) {
		// given:none

		// when then
		assertThatThrownBy(() -> new StrikeResult(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR] strike 할 수 있는 값은 0-3 범위 내여야 합니다.");
	}

	@DisplayName("increase 한 경우, strike 갯수가 한개 증가한 StrikeResult 객체를 반환한다.")
	@Test
	void increase() {
		// given
		final StrikeResult strikeResult = new StrikeResult();

		// when then
		assertEquals(new StrikeResult(1), strikeResult.increase());
	}

	@DisplayName("increase 한 경우, 4 이상의 strike 가 되면 에러를 발생시킨다.")
	@Test
	void increase_fail_test() {
		// given
		final StrikeResult strikeResult = new StrikeResult(3);

		// when then
		assertThatThrownBy(strikeResult::increase)
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR] strike 할 수 있는 값은 0-3 범위 내여야 합니다.");
	}

	@DisplayName("toString 테스트")
	@ParameterizedTest(name = "{displayName} / input = {0} / 예상 = {1}")
	@CsvSource(value = {"0:''", "1:1스트라이크", "2:2스트라이크", "3:3스트라이크"}, delimiter = ':')
	void toString(int input, String expected) {
		// given
		final StrikeResult strikeResult = new StrikeResult(input);

		// when then
		assertEquals(expected, strikeResult.toString());
	}
}
