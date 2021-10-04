package baseball.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.exception.NotThreeDigitNumberException;

class BaseballServiceTest {
	private BaseballService baseballService = new BaseballService();

	@Test
	@DisplayName("정답이 세자리 양의 정수인지 테스트")
	void createAnswer_ShouldReturnThreeDigitNumber() {
		int answer = baseballService.createAnswer();
		assertEquals(true, answer > 99 && answer < 1000);
	}

	@Test
	@DisplayName("정답에 사용된 숫자에 중복이 없는지 테스트")
	void createAnswer_ShouldHaveNoDuplicateDigits() {
		int answer = baseballService.createAnswer();
		char[] digits = String.valueOf(answer).toCharArray();
		HashSet<Character> set = new HashSet<>();
		for (int i = 0; i < digits.length; i++) {
			set.add(digits[i]);
		}
		assertEquals(true, digits.length == set.size());
	}

	@ParameterizedTest
	@ValueSource(strings = {"abc", "!@#", "가나다", "12a", "34b"})
	@DisplayName("입력값이 Integer로 변환될 수 없으면 NumberFormatException 반환하는지 테스트")
	void isValidInput_ShouldThrowNumberFormatException(String input) {
		assertThrows(NumberFormatException.class, () -> {
			baseballService.isValidInput(input);
		});
	}

	@ParameterizedTest
	@ValueSource(strings = {"1234", "12", "0", "-1", "-12", "000"})
	@DisplayName("입력값이 세자리 양의 정수가 아니면 NotTreeDigitsNumberException 반환하는지 테스트")
	void isValidInput_ShouldThrowNotThreeDigitsNumberException(String input) {
		assertThrows(NotThreeDigitNumberException.class, () -> {
			baseballService.isValidInput(input);
		});
	}

	@ParameterizedTest
	@ValueSource(strings = {"123", "765", "102", "190"})
	@DisplayName("입력값이 중복된 숫자가 없는 세자리 양의 정수라면 true 반환하는지 테스트")
	void isValidInput_WhenInputIsThreeDigitNumberWithoutDuplicateDigits_ShouldReturnTrue(String input) {
		assertEquals(true, baseballService.isValidInput(input));
	}
}
