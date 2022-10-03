package study;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("문자열 \"1,2\"를 ,로 분리한 경우 배열의 값 및 사이즈")
    void splitByComma() {
        // given
        String data = "1,2";

        // when
        String[] splitArray = data.split(",");

        // then
        assertThat(splitArray).contains("1", "2");
        assertThat(splitArray.length).isEqualTo(2);
    }

    @Test
    @DisplayName("문자열 \"1\"을 ,로 분리한 경우 1만 포함되는지 여부")
    void splitByCommaContainsOneExactly() {
        // given
        String data = "1";

        // when
        String[] splitArray = data.split(",");

        // then
        assertThat(splitArray).containsExactly("1");
        assertThat(splitArray.length).isEqualTo(1);
    }

    @Test
    @DisplayName("문자열 \"(1,2)\"의 소괄호 제거")
    void removeBracket() {
        // given
        String data = "(1,2)";
        int openBracketIndex = data.indexOf('(');
        int closeBracketIndex = data.indexOf(')');

        // when
        String result = data.substring(openBracketIndex + 1, closeBracketIndex);

        // then
        assertThat(result).doesNotContain("(", ")");
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열 \"abc\"에서 유효하지 않은 위치의 문자를 추출")
    void extractCharacterByPosition() {
        // given
        String data = "abc";
        int invalidBoundary = 3;

        // then
        assertThatThrownBy(() -> data.charAt(invalidBoundary))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining(String.format("String index out of range: %d", invalidBoundary));

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> data.charAt(invalidBoundary))
                .withMessageMatching("String index out of range: \\d+");
    }
}
