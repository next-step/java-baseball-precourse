package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {

    @Test
    void string_split_contains_test() {
        String text = "1,2";
        assertThat(text.split(",")).contains("1", "2");
    }

    @Test
    void string_split_contains_exactly_test() {
        String text = "1";
        assertThat(text.split(",")).containsExactly("1");
    }

    @Test
    void string_substring_test() {
        String text = "(1,2)";
        assertThat(text.substring(1, text.length() - 1)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("testing charAt when insert in-range")
    void string_charAt_success_test() {
        String text = "abc";
        assertThat(text.charAt(0)).isEqualTo('a');
        assertThat(text.charAt(1)).isEqualTo('b');
        assertThat(text.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("testing IndexOutOfBoundException when insert out-of-range to charAt")
    void string_charAt_throw_exception_test() {
        String text = "abc";
        assertThatThrownBy(() -> text.charAt(6))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("index out of range: 6");
    }

}
