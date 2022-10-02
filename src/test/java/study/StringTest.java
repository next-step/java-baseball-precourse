package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringTest {

    @Test
    @DisplayName("split() 메소드를 통한 문자열 분리")
    void splitTest1() {
        // given
        String input = "1,2";

        // when
        String[] results = input.split(",");

        // then
        Assertions.assertThat(results).contains("1", "2");
    }

    @Test
    @DisplayName("split() 메소드 결과 배열 값 확인")
    void splitTest2() {
        // given
        String input = "1";

        // when
        String[] results = input.split(",");

        // then
        Assertions.assertThat(results).containsExactly("1");
    }

    @Test
    @DisplayName("substring() 메소드를 통한 소괄호() 제거")
    void substringTest() {
        // given
        String input = "(1,2)";

        // when
        String result = input.substring(1, input.length() - 1);

        // then
        Assertions.assertThat(result).isEqualTo("1,2");
    }

    @ParameterizedTest
    @CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
    @DisplayName("charAt() 메소드를 통해 특정 위치의 문자 가져오기")
    void charAtTest(int index, char expected) {
        // given
        String input = "abc";

        // when
        char result = input.charAt(index);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("charAt() 메소드를 활용해 특정 위치의 문자를 가져올 떄 위치 값을 벗어나면 StringIndexOutOfBoundsException 발생")
    void chartAtExceptionTest() {
        // given
        String input = "abc";

        // when, then
        Assertions.assertThatThrownBy(() -> input.charAt(input.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + input.length());
    }
}
