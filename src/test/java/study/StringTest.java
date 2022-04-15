package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringTest {

    @DisplayName("요구사항 1 - 1,2를 ,로 분리")
    @Test
    void twoNumberSplitTest() {
        String target = "1,2";
        String[] result = target.split(",");
        assertThat(result[0]).isEqualTo("1");
        assertThat(result[1]).isEqualTo("2");
        assertThat(result).hasSize(2).contains("1", "2");
    }

    @DisplayName("요구사항 1 - 1을 ,로 분리")
    @Test
    void onlyOneNumberSplitTest() {
        String target = "1";
        String[] result = target.split(",");
        assertThat(result[0]).isEqualTo("1");
        assertThat(result).hasSize(1).contains("1");
    }

    @DisplayName("요구사항 2 - (1,2)를 substring() 메소드 사용해 1,2로 반환")
    @Test
    void subStringTest() {
        String target = "(1,2)";
        String result = target.substring(1, target.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("요구사항 3 - 특정 인덱스의 문자를 가져온다")
    @Test
    void charAtTest() {
        String target = "abc";
        assertThat(target.charAt(0)).isEqualTo('a');
        assertThat(target.charAt(1)).isEqualTo('b');
        assertThat(target.charAt(2)).isEqualTo('c');
    }

    @DisplayName("요구사항 3 - 위치 값을 벗어나면 StringIndexOutOfBoundsException 발생")
    @Test
    void charAtStringIndexOutOfBoundsExceptionTest() {
        String target = "abc";
        int wrongIndex = target.length()+1;
        assertThatThrownBy(() -> {
            target.charAt(wrongIndex);
        }).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessage("String index out of range: " + wrongIndex);

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                target.charAt(wrongIndex);
        }).withMessageMatching("String index out of range: \\d+");
    }
}
