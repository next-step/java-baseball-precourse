package study;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

	@DisplayName("split 함수 테스트 / 콤마를 기반으로 split 한다.")
	@Test
	void split() {
		// given when
		final String[] splitted = "1,2".split(",");

		// then
		assertAll(
			() -> assertThat(splitted).containsExactly("1", "2"),
			() -> assertThat(splitted).contains("1"),
			() -> assertThat(splitted).contains("2")
		);
	}

	@DisplayName("substring 함수 테스트 / 문자열을 감싸고있는 괄호를 제거한다.")
	@Test
	void substring() {
		// given
		final String target = "(1,2)";

		// when
		final String substring = target.substring(1, target.length() - 1);

		// then
		assertEquals("1,2", substring);
	}

	@DisplayName("charAt 함수 테스트 / 문자열의 길이를 넘은 곳의 인덱스를 접근하여 StringIndexOutOfBounds Exception 을 발생시킨다.")
	@Test
	void charAt() {
		// given
		final String abc = "abc";

		// when then
		assertThatThrownBy(() -> abc.charAt(3))
			.isInstanceOf(IndexOutOfBoundsException.class)
			.hasMessageContaining("String index out of range: 3");

		// pattern 을 사용할 수 있다.
		assertThatExceptionOfType(IndexOutOfBoundsException.class)
			.isThrownBy(() -> abc.charAt(3))
			.withMessageMatching("String index out of range: \\d+");
	}

}
