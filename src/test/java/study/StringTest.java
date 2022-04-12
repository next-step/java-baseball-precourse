package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void Should_SplitTheString_When_WithColon() {
        // given
        String case1 = "1,2";
        // when
        final String[] splitCase1 = case1.split(",");
        // then
        assertThat(splitCase1).contains("1").contains("2");

        // given
        String case2 = "1";
        // when
        final String[] splitCase2 = case2.split(",");
        // then
        assertThat(splitCase2).containsExactly("1");
    }
}
