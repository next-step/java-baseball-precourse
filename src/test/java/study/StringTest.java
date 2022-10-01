package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringTest {
    private static final int POSITION_CORRECTION_VALUE = 1;

    @DisplayName("문자열 \"1,2\" 를 ',' 기준으로 split 하여 1과 2로 분리되는지 확인한다.")
    @Test
    void splitWithComma() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
    }

    @DisplayName("문자열 \"1\" 를 ',' 기준으로 split 하여 1만 포함하는 배열로 반환되는지 확인한다.")
    @Test
    void splitSingleText() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @DisplayName("문자열 \"(1,2)\" 값을 substring() 메서드를 활용해 괄호를 제거하고, \"1,2\"를 반환한다.")
    @Test
    void substring() {
        String s = "(1,2)";
        int open = s.indexOf("(");
        int close = s.indexOf(")");

        String result = s.substring(open + POSITION_CORRECTION_VALUE, close);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("\"abc\" 문자열을 charAt() 메서드를 통해 특정위치를 가져오고, 위치 값을 벗어나면 StringIndexOutOfBoundsException을 발생함을 확인한다.")
    @Test
    void charAt() {
        String s = "abc";
        assertThatThrownBy(() -> s.charAt(5)).isInstanceOf(StringIndexOutOfBoundsException.class)
                                             .hasMessageContaining("String index out of range: 5");
    }
}