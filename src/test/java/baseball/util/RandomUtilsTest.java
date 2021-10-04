package baseball.util;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomUtilsTest {

	@DisplayName("랜덤하게 생성된 3개의 숫자가 중복되지 않는지 테스트")
	@Test
	void generateNoDuplicateNumbers() {
		// given
		final int startInclusive = 1;
		final int endInclusive = 9;
		final int resultSize = 3;

		// when
		final List<Integer> numbers = RandomUtils.generateNoDuplicateNumbers(startInclusive, endInclusive, resultSize);

		// then
		assertEquals(3, numbers.size());
		assertEquals(3, new HashSet<>(numbers).size());
	}

	@DisplayName("ResultSize 가 생성될 수 있는 모든 숫자보다 큰 경우 에러를 반환하는 테스트")
	@Test
	void generateNoDuplicateNumbers_resultSize_larger_than_available() {
		// given
		final int startInclusive = 1;
		final int endInclusive = 9;
		final int resultSize = 10;

		// when then
		assertThatThrownBy(() -> RandomUtils.generateNoDuplicateNumbers(startInclusive, endInclusive, resultSize))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR] 범위내의 모든숫자보다 resultSize 값이 클 수 없습니다.");
	}

	@DisplayName("ResultSize 가 1보다 작은경우")
	@Test
	void generateNoDuplicateNumbers_resultSize_smaller_than_1() {
		// given
		final int startInclusive = 1;
		final int endInclusive = 9;
		final int howMuch = 0;

		// when then
		assertThatThrownBy(() -> RandomUtils.generateNoDuplicateNumbers(startInclusive, endInclusive, howMuch))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR] resultSize 는 1보다 작을 수 없습니다.");
	}
}