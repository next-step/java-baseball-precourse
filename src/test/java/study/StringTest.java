package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@Test
	@DisplayName("1,2라는 값을 ,를 구분자로 분리")
	void splitTest() {
		String input = "1,2";
		String[] split = input.split(",");

		assertThat(split).contains("2", "1"); // 순서가 맞지 않더라도 값만 있으면 성공
		assertThat(split).containsExactly("1", "2"); // 순서까지 맞아야 성공
	}

	@Test
	@DisplayName("(1,2)라는 값을 substring()을 활용하여 ()를 제거한 뒤 1,2로 반환")
	void substringTest() {
		String input = "(1,2)";

		String substring = input.substring(1);
		substring = substring.substring(0, 3);

		assertThat(substring).isEqualTo("1,2");

	}

	@Test
	@DisplayName("abc라는 값에 대해 charAt()을 활용하여 특정위치 문자 반환")
	void charAtTest() {
		String input = "abc";

		char c = input.charAt(2);
		assertThat(c).isEqualTo('c');

		assertThatThrownBy(() -> {
			char charAt = input.charAt(3);
		}).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 3");

		assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
			.isThrownBy(() -> {
				char charAt = input.charAt(3);
			}).withMessageMatching("String index out of range: \\d+");

	}
}
