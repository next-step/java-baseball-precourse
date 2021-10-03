package baseball.util;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidationUtilsTest {

	@DisplayName("isValidLength() / input 의 길이가 3이 아닌 경우 IllegalArgumentException 을 던지도록 한다.")
	@Test
	void isValidLength() {
		// given
		final String input = "123";

		// when then
		assertDoesNotThrow(() -> ValidationUtils.isValidLength(input));
	}

	@DisplayName("isValidLength() / input 의 길이가 3이 아닌 경우 IllegalArgumentException 을 던지도록 한다.")
	@ParameterizedTest
	@ValueSource(strings = {"ab", "abcd"})
	void isValidLength_fail_case(String input) {
		// given:none

		// when then
		assertThatThrownBy(() -> ValidationUtils.isValidLength(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR] 길이가 3인 문자열만 입력가능합니다.");
	}
}
