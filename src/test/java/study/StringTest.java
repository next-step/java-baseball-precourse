package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
	String testStr;

	/*
	* contains - 순서, 중복 상관없이 포함
	* containsOnly - 중복 상관없이 포함
	* containsExactly - 중복 순서 모두 일치
	* */

	@Test
	@DisplayName("1,2 나누기")
	public void twoNumberSplitTest() {
		testStr = "1,2";
		String[] result = testStr.split(",");
		assertThat(result).isNotEmpty()
			.contains("1", "2");
	}

	@Test
	@DisplayName("1 나누기")
	public void singleNumberSplitTest() {
		testStr = "1";
		String[] result = testStr.split(",");
		assertThat(result).isNotEmpty()
			.containsExactly("1");
	}

	@Test
	@DisplayName("괄호제거 테스트")
	public void parenthesisNumberSplitTest() {
		testStr = "(1,2)";
		String result = testStr.substring(1,testStr.length()-1);
		assertThat(result).isNotEmpty()
			.isEqualTo("1,2");
	}

	@Test
	@DisplayName("chartAt "
		+ " 테스트")
	public void charAtTest() {
		testStr = "abc";
		assertThat(testStr.charAt(2)).isEqualTo('c');
	}

	@Test
	@DisplayName("chartAt의 문자열의 범위를 벗어날 경우 StringIndexOutOfBoundsException 발생 테스트")
	public void charAtExceptionTest() {
		testStr = "abc";
		assertThatThrownBy(() -> {
			testStr.charAt(testStr.length());
		}).isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessageContaining("out of range");
	}

	@Test
	@DisplayName("chartAt의 문자열의 범위를 벗어날 경우 StringIndexOutOfBoundsException 발생 테스트 두번째")
	public void charAtExceptionTest2() {
		testStr = "abc";
		assertThatExceptionOfType((StringIndexOutOfBoundsException.class)).isThrownBy(() -> {
			testStr.charAt(5);
		}).withMessageMatching("String index out of range: \\d+");
	}

	@Test
	@DisplayName("NullPointerException 테스트")
	public void nullPointerTest() {
		assertThatNullPointerException()
			.isThrownBy(() -> {
				testStr.charAt(0);
			});
	}
}
