package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @DisplayName("문자열을 특정 문자로 분리할 수 있다")
    @Test
    void 문자열이_분리된다() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
    }

    @DisplayName("하나의 문자열을 분리할 경우 해당 값만 배열로 반환된다")
    @Test
    void 하나의_문자열이_분리된다() {
        assertThat("1".split(",")).containsExactly("1");
    }

    @DisplayName("문자열에서 소괄호를 제거할 수 있다")
    @Test
    void 소괄호가_제거된다() {
        String input = "(1,2)";
        assertThat(input.substring(1, input.length() - 1)).isEqualTo("1,2");
    }

    @DisplayName("문자열에서 특정 위치의 문자를 가져올 수 있다")
    @Test
    void 문자위치를_알수있다() {
        assertThat("abc".charAt(0)).isEqualTo('a');
    }

    @DisplayName("문자열에서 특정 위치값이 범위를 초과할 경우 예외가 발생한다")
    @Test
    void 위치값이_잘못되면_예외가_발생한다() {
        assertThatThrownBy(() -> {
            "abc".charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }
}
