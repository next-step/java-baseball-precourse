package baseball.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParseUtilsTest {

	@DisplayName("string 을 파싱하여 list<Integer> 로 담는 경우에 대한 테스트")
	@Test
	void toIntList() {
		// given
		final String input = "123456";

		// when then
		assertThat(ParseUtils.toIntList(input)).containsExactly(1, 2, 3, 4, 5, 6);
	}
}