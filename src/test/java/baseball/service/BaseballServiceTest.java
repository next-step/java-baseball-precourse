package baseball.service;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.exception.NotThreeDigitNumberException;

class BaseballServiceTest {
	private BaseballService baseballService = new BaseballService();

	@BeforeEach
	void setUp() {

	}

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

	@ParameterizedTest
	@ValueSource(strings = {"456", "789", "409"})
	@DisplayName("정답이 123일 때, 입력값이 정답과 서로 동일한 숫자를 가지지 않은 경우 0볼, 0스트라이크를 반환하는지 테스트")
	void returnResult_ShouldReturnZeroBallAndZeroStrike(String input) {
		setAnswer(123);
		HashMap<String, Integer> result = baseballService.returnResult(input);
		assertEquals(0, result.get("ball"));
		assertEquals(0, result.get("strike"));
	}

	@ParameterizedTest
	@CsvSource(value = {
		"456,0,0" // 0볼, 0스트라이크
		, "123,0,3" // 0볼, 3스트라이크
		, "451,1,0" // 1볼, 0스트라이크
		, "431,2,0" // 2볼, 0스트라이크
		, "231,3,0" // 3볼, 0스트라이크
		, "145,0,1" // 0볼, 1스트라이크
		, "124,0,2" // 0볼, 2스트라이크
		, "142,1,1" // 1볼, 1스트라이크
		, "132,2,1" // 2볼, 1스트라이크
	}, delimiter = ',')
	@DisplayName("정답이 123일 때, 올바른 볼과 스트라이크 수를 반환하는지 테스트")
	void returnResult_ShouldReturnExpectedBallAndStrikeCount(String input, int ball, int strike) {
		setAnswer(123);
		HashMap<String, Integer> result = baseballService.returnResult(input);
		assertEquals(ball, result.get("ball"));
		assertEquals(strike, result.get("strike"));
	}

	private void setAnswer(int answer) {
		try {
			Field field = baseballService.getClass().getDeclaredField("answer");
			field.setAccessible(true);
			field.setInt(baseballService, answer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
