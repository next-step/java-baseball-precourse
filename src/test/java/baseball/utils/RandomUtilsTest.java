package baseball.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomUtilsTest {

	@DisplayName("랜덤하게 생성된 3개의 숫자가 중복되지 않는지 테스트")
	@Test
	void generateNoDuplicateNumbers() {
		// given:none

		// when
		final List<Integer> numbers = RandomUtils.generateNoDuplicateThreeBaseball();

		// then
		assertEquals(3, numbers.size());
		assertEquals(3, new HashSet<>(numbers).size());
	}
}