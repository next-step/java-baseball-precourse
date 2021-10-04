package baseball.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballServiceTest {
	private BaseballService baseballService = new BaseballService();

	@Test
	@DisplayName("정답이 세자리 양의 정수인지 테스트")
	void createAnswer_ShouldReturnThreeDecimalDigits() {
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
}
