package baseball.utils;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IntegerUtilsTest {
	@Test
	@DisplayName("문자열을 Integer 타입의 리스트로 반환한다.")
	void convertStringToIntegerList() {
		// given
		String intString = "123";

		// when
		List<Integer> list = IntegerUtils.convertStringToIntegerList(intString);

		// then
		assertThat(list)
			.hasSize(3)
			.containsExactly(1, 2, 3);

	}
}