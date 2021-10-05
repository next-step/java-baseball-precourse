package baseball.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ExitStatusTest {

	@DisplayName("입력에 대한 ExitStatus 반환 테스트")
	@ParameterizedTest(name = "{displayName} / 입력 = {0} / ExitStatus = {1}")
	@CsvSource(value = {"1:REPLAY", "2:EXIT", "3:INVALID", "invalid:INVALID"}, delimiter = ':')
	void from(String input, ExitStatus expected) {
		// given: none

		// when then
		assertEquals(expected, ExitStatus.from(input));
	}

}