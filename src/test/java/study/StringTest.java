package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class StringTest {
    @Test
    @DisplayName("splitTest:[success]")
    void splitTest() {
        //given
        String str1 = "1,2";
        String str2 = "1";
        //when
        String[] str1Result = str1.split(",");
        String[] str2Result = str2.split(",");
        //then
        assertThat(str1Result).contains("1", "2").containsExactly("1", "2");
        assertThat(str2Result).contains("1").containsExactly("1");
    }

    @Test
    @DisplayName("substringTest:[success]")
    void substringTest() {
        //given
        String str1 = "(1,2)";
        //when
        String str1Result = str1.substring(1, str1.length() - 1);
        //then
        assertThat(str1Result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAtTest:[success]")
    void charAtTest() {
        //given
        String str1 = "abc";
        // when & then
        assertThatThrownBy(() -> str1.charAt(4))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }
}
