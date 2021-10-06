package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void split_with_delim() {
        String delim = ",";

        Assertions.assertThat("1,2".split(delim)).contains("1", "2");
        Assertions.assertThat("1".split(delim)).containsExactly("1");
    }

    @Test
    void remove() {
        String str = "(1,2)";

        Assertions.assertThat(str.substring(1, str.length() - 1)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("abc 가 입력으로 주어졌을 때 charAt()을 통해 특정 문자를 가져오고," +
            "찾고자 하는 문자가 abc의 index를 벗어난 경우 StringIndexOutOfBoundsException이 발생됨을 확인한다.")
    void get_char() {
        String str = "abc";

        Assertions.assertThat(str.charAt(0)).isEqualTo('a');
        Assertions.assertThat(str.charAt(2)).isEqualTo('c');
        Assertions.assertThatThrownBy(() -> {
            str.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
