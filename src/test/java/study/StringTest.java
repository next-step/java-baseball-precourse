package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class StringTest {

	@Test
	void 요구사항_1(){
		String a = "1,2";
		String b = "1";
		assertThat(a.split(",")).contains("1","2");
		assertThat(b.split(",")).containsExactly("1");
	}

	@Test
	void 요구사항_2(){
		String a = "(1,2)";
		assertThat(a.substring(a.indexOf("("),a.indexOf(")"))).contains("1,2");
	}

	@Test
	@DisplayName("문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생")
	void 요구사항_3(){
		String str = "abc";
		int index = 5;

		assertThatThrownBy(() -> str.charAt(index))
				.isInstanceOf(StringIndexOutOfBoundsException.class);
	}
}
