package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void split_테스트1(){
        String str = "1,2";
        String[] split = str.split(",");
        assertThat(split)
                .contains("1")
                .contains("2");
    }

    @Test
    void split_테스트2() {
        String str = "1";
        String[] split = str.split(",");
        assertThat(split)
                .containsExactly("1");
    }

    @Test
    void substring_테스트(){
        String str = "(1,2)";
        String substr = str.substring(1, str.length() - 1);
        assertThat(substr).isEqualTo("1,2");
    }

    @Test
    void charAt_테스트(){
        String str = "abc";
        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThat(str.charAt(2)).isEqualTo('c');
    }

    @DisplayName("charAt index를 벗어날 경우 StringIndexOutOfBoundsException 발생")
    @Test
    void charAt_테스트_실패(){
        String str = "abc";
        assertThatThrownBy(() -> {
            str.charAt(str.length());
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
        .hasMessageContaining("String index out of range: 3");

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> str.charAt(str.length()))
                .withMessageMatching("String index out of range: \\d+");
    }
}
