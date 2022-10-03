package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("contains test")
    public void contains_afterStringSplit () {
        String willSplitString = "1,2";
        assertThat(willSplitString.split(",")).contains("1", "2");
    }

    @Test
    @DisplayName("containsExactly test")
    public void containsExactly_afterStringSplit() {
        String willSplitString = "1";
        assertThat(willSplitString.split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("substring test")
    public void isEqualTo_stringSubstringTest() {
        String isEqualTo_afterSubstring = "(1,2)";
        assertThat("(1,2)".substring(1, 4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt test")
    public void charAt_shouldReturnSpecificIndexValue() {
        String charAtTestString = "abc";

        assertThat(charAtTestString.charAt(0)).isEqualTo('a');
        assertThat(charAtTestString.charAt(1)).isEqualTo('b');
        assertThat(charAtTestString.charAt(2)).isEqualTo('c');

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    charAtTestString.charAt(3);
                }).withMessageMatching("String index out of range: \\d+");
    }

}
