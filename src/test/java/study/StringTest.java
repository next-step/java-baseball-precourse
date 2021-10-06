package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
	@DisplayName("1,2을 ,로 split 했을 때 1과 2로 분리되는지 확인")
	@Test
	void split_containsExactly() {
		String[] values = "1,2".split(",");
		assertThat(values).containsExactly("1", "2");
	}

	@DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
	@Test
	void split_contains() {
		String[] values = "1".split(",");
		assertThat(values).contains("1");
	}

	@DisplayName("(1,2) 값이 주어졌을 때 ()을 제거하고 1,2를 반환하는지 확인")
	@Test
	void substring() {
		String input = "(1,2)";
		String output = input.substring(1, input.length() - 1);
		assertThat(output).isEqualTo("1,2");
	}

	@DisplayName("abc 값이 주어졌을 때 특정 위치의 문자를 반환하는지 확인")
	@Test
	void charAt() {
		String input = "abc";
		assertThat(input.charAt(1)).isEqualTo('b');
	}

	@DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는지 확인")
	@Test
	void charAt_StringIndexOutOfBoundsException() {
		String input = "abc";
		assertThatThrownBy(() -> input.charAt(input.length()))
			.isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessageContaining("String index out of range: " + input.length());
	}
}