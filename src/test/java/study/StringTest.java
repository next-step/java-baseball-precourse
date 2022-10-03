package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void splitStringAsComma() {
        String str = "1,2";
        String[] result = str.split(",");

        String[] expected = new String[]{"1", "2"};
        assertThat(result).contains(expected);
        assertThat(result).containsExactly(expected);
    }

    @Test
    void splitOneLengthString() {
        String str = "1";
        String[] result = str.split(",");

        String[] expected = new String[]{"1"};
        assertThat(result).contains(expected);
        assertThat(result).containsExactly(expected);
    }

    @Test
    void deleteBrackets() {
        String str = "(1,2)";
        int StringSize = str.length() - 1;
        String result = str.substring(1, StringSize);

        String expected = "1,2";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("문자열 범위 밖 조회 에러 테스트")
    void exceptionTest() {
        String str = "abc";
        int outOfBoundIndex = 3;

        assertThatThrownBy(() -> {
            str.charAt(outOfBoundIndex);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: %s", outOfBoundIndex);


        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    str.charAt(outOfBoundIndex);
                })
                .withMessage("String index out of range: %s", outOfBoundIndex)
                .withMessageContaining("String index out of range")
                .withNoCause();
    }
}
