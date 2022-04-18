package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

    @Test
    void 요구사항_1() {
        List<String> values = 콤마_문자열_리스트로_만들기("1,2");
        assertThat(values).contains("1", "2");
        assertThat(values).containsExactly("1", "2");

        List<String> values2 = 콤마_문자열_리스트로_만들기("1");
        assertThat(values2).contains("1");
        assertThat(values2).containsExactly("1");
    }

    @Test
    void 요구사항_2() {
        assertThat(괄호_지우기("(1,2)")).contains("1,2");
    }

    @Test
    void 요구사항_3() {
        assertThat(특정_위치_문자_가져오기("abc", 0).contains("a")).isTrue();
        assertThat(특정_위치_문자_가져오기("abc", 1).contains("b")).isTrue();
        assertThat(특정_위치_문자_가져오기("abc", 2).contains("c")).isTrue();
    }

    @Test
    @DisplayName("특정 위치 문자 가져올때 위치 값을 벗어났다.")
    void 요구사항_3_예외() {
        assertThatThrownBy(() -> {
            특정_위치_문자_가져오기("abc", 4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }

    @DisplayName("콤마 문자열 리스트로 만든다.")
    public List<String> 콤마_문자열_리스트로_만들기(String value) {
        return Arrays.asList(value.split(","));
    }

    @DisplayName("괄호 지운다.")
    public String 괄호_지우기(String value) {
        return value.substring(value.lastIndexOf("(") + 1, value.lastIndexOf(")"));
    }

    @DisplayName("특정 위치 문자 가져온다.")
    public String 특정_위치_문자_가져오기(String value, int index) {
        return String.valueOf(value.charAt(index));
    }
}
