package study;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
	@DisplayName("\"1,2\"를 ,로 split했을 때 1과 2로 잘 분리되는지 확인")
	@Test
	void splitTestForOneTwoWithComma() {
		assertThat("1,2".split(","))
			.contains("1", "2");
	}

	@DisplayName("\"1\"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
	@Test
	void splitTestForOneArrayWithComma() {
		assertThat("1".split(","))
			.containsExactly("1");
	}

	@DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 \"1,2\"를 반환되는지 확인")
	@Test
	void substringTest() {
		assertThat("(1,2)".substring(1, 4))
			.isEqualTo("1,2");
	}

	@DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는지 확인")
	@Test
	void charAtTest() {
		int index = 5;
		assertThatThrownBy(() -> "abc".charAt(index))
			.isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessageContaining(String.format("String index out of range: %d", index));
	}

}
