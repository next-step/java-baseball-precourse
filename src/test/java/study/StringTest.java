package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
	
	@Test
	void 분리_스플릿_테스트(){
		String value = "1,2";

		String[] result = value.split(",");

		assertThat(result)
			.contains("1", "2");
	}

	@Test
	void 분리없는_스플릿_테스트(){
		String value = "1";

		String[] result = value.split(",");

		assertThat(result)
			.containsExactly("1");
	}

	@Test
	void substring_테스트(){
		String value = "(1,2)";
		String expected = "1,2";

		String result = value.substring(1, 4);

		assertThat(result).isEqualTo(expected);
	}
	
	@Test
	@DisplayName("charAt 성공 테스트")
	void charAt_성공_테스트(){
		String value = "abc";

		char firstChar = value.charAt(0);
		char secondChar = value.charAt(1);
		char thirdChar = value.charAt(2);

		assertThat(firstChar).isEqualTo('a');
		assertThat(secondChar).isEqualTo('b');
		assertThat(thirdChar).isEqualTo('c');
	}

	@Test
	@DisplayName("charAt 잘못된 위치값 테스트")
	void charAt_실패_테스트(){
		String value = "abc";
		int outIndex = value.length() + 1;

		assertThatThrownBy(() -> {
			value.charAt(outIndex);
		})
		.isInstanceOf(StringIndexOutOfBoundsException.class)
		.hasMessageContaining(String.format("String index out of range: %d", outIndex));
	}
}
