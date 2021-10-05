package baseball.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ExitStatusTest {

	@DisplayName("1을 입력할 경우, Exitstatus.REPLAY, 2를 입력한경우 Exitstatus.EXIT, 그 이외의 경우 ExitStatus.INVALID 반환 테스트")
	@ParameterizedTest(name = "{displayName} : {0}")
	@CsvSource(value = {"1:REPLAY", "2:EXIT", "3:INVALID", "invalid:INVALID"}, delimiter = ':')
	void from(String input, ExitStatus expected) {
		// given: none

		// when then
		assertEquals(expected, ExitStatus.from(input));
	}

}