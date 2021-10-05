package baseball.utils;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidationUtilsTest {

	@DisplayName("isValidLength() / input 의 길이가 3인지 확인한다.")
	@Test
	void isValidLength() {
		// given
		final String input = "123";

		// when then
		assertDoesNotThrow(() -> ValidationUtils.isValidLength(input));
	}

	@DisplayName("isValidLength() / input 의 길이가 3이 아닌 경우 IllegalArgumentException 을 던지도록 한다.")
	@ParameterizedTest(name = "{displayName} / input = {0}")
	@ValueSource(strings = {"ab", "abcd"})
	void isValidLength_fail_case(String input) {
		// given:none

		// when then
		assertThatThrownBy(() -> ValidationUtils.isValidLength(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR] 길이가 3인 문자열만 입력가능합니다.");
	}

	@DisplayName("containsBetweenOneToNine() / input String 이 모두 1-9 사이의 문자인지 검증한다.")
	@Test
	void containsBetweenOneToNine() {
		// given
		final String input = "123456789";

		// when then
		assertDoesNotThrow(() -> ValidationUtils.containsBetweenOneToNine(input));
	}

	@DisplayName("containsBetweenOneToNine() / input String 1-9 사이의 문자가 아닌경우 IllegalArgumentException 을 던진다.")
	@ParameterizedTest(name = "{displayName} / input = {0}")
	@ValueSource(strings = {"012", "abc", "1ac", "0"})
	void containsBetweenOneToNine_fail_test(String input) {
		// given: none

		// when then
		assertThatThrownBy(() -> ValidationUtils.containsBetweenOneToNine(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR] 1-9 까지의 문자만 입력가능합니다.");
	}

	@DisplayName("hasNoDuplicateNumber() / 숫자로 된 문자열이 중복되는지 검증한다.")
	@Test
	void hasNoDuplicateNumber() {
		// given
		final String input = "123456789";

		// when then
		assertDoesNotThrow(() -> ValidationUtils.hasNoDuplicateNumber(input));
	}

	@DisplayName("hasNoDuplicateNumber() / 숫자로 된 문자열이 중복된 경우, IllegalArgumentException 을 던진다.")
	@ParameterizedTest(name = "{displayName} / input = {0}")
	@ValueSource(strings = {"1233", "44", "1123", "1223"})
	void hasNoDuplicateNumber_fail_test(String input) {
		// given: none

		// when then
		assertThatThrownBy(() -> ValidationUtils.hasNoDuplicateNumber(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR] 중복된 숫자가 포함되어있는 문자열입니다.");
	}
}
