package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringTest {

	@DisplayName("\"1,2\" 문자열을 넘기면 1,2로 분리된 배열이 반환된다")
	@Test
	void given_string_when_split_by_commas_then_return_array_containing_two_datas() {
		String inputData = "1,2";
		String[] expectedData = new String[] {"1", "2"};

		assertThat(inputData.split(","))
			.containsExactly(expectedData);
	}

	@DisplayName("\"1\" 문자열을 넘기면 1만 담긴 배열이 반환된다")
	@Test
	void given_string_when_split_by_commas_then_return_array_containing_one_data() {
		String inputData = "1";
		String[] expectedData = new String[] {"1"};

		assertThat(inputData.split(","))
			.contains(expectedData);
	}

	@DisplayName("\"(1,2)\" 문자열을 넘기면 소괄호를 제거하고 \"1,2\"만 반환된다")
	@Test
	void given_string_then_return_string_with_parentheses_removed() {
		String inputData = "(1,2)";
		String expectedData = "1,2";
		int startIndex = 1;
		int endIndex = inputData.length() - 1;

		assertThat(inputData.substring(startIndex, endIndex))
			.isEqualTo(expectedData)
			.doesNotContain("(", ")");
	}

	@ParameterizedTest(name = "문자가 위치한 인덱스 {0}를 입력하면 {1}을 반환한다")
	@DisplayName("특정 인덱스의 문자를 가져온다.")
	@CsvSource({"0,a", "1,b", "2,c"})
	void given_index_then_return_character_at_index(int index, char expectedData) {
		assertThat("abc".charAt(index))
			.isEqualTo(expectedData);
	}

	@DisplayName("범위를 벗어난 인덱스를 접근하면 예외를 발생시킨다")
	@Test
	void when_access_out_of_range_index_then_throw_exception() {
		assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
			.isThrownBy(() -> "abc".charAt(4));
	}
}
