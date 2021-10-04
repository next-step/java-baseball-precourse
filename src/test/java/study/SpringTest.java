package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SpringTest {

    @Test
    void split()  {
        //given
        final String input = "1,2";
        //when
        final String[] result = input.split(",");
        //then
        assertThat(result).contains("1", "2");
    }

    @Test
    void split2() {
        //given
        final String input = "1";
        //when
        final String[] result = input.split(",");
        //then
        assertThat(result).containsExactly("1");

    }

    @Test
    void subString() {
        //given
        final String input = "(1,2)";
        //when
        final String result = input.substring(1, input.length() - 1);
        //then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자 가져오기, 위치 값 벗어나면 예외 발생")
    void charAt() {
        //given
        final String input = "abc";
        //when
        final char result = input.charAt(0);
        //then
        assertThat(result).isEqualTo('a');
        assertThatThrownBy(() -> input.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class);

    }
}