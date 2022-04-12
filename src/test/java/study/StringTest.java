package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void Should_SplitTheString_When_WithColon() {
        // given
        String testCase1 = "1,2";
        // when
        final String[] result1 = testCase1.split(",");
        // then
        assertThat(result1).contains("1").contains("2");

        // given
        String testCase2 = "1";
        // when
        final String[] result2 = testCase2.split(",");
        // then
        assertThat(result2).containsExactly("1");
    }

    @Test
    void Should_SubstringTheString_When_WithBracket() {
        // given
        String testCase = "(1,2)";
        // when
        final int indexLeftBracket = testCase.indexOf("(");
        final int indexRightBracket = testCase.indexOf(")");
        final String result = testCase.substring(indexLeftBracket+1, indexRightBracket);
        // then
        assertThat(result).isEqualTo("1,2");
    }
}
