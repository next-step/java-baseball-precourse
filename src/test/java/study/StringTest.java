package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringTest {
    /*
    * 요구사항
    * "1,2"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
    * "1"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다
    * */

    @Test
    @DisplayName("1,2를 ,로 split -> 1과 2로 분리")
    void split_test_1() {
        // given
        String value = "1,2";

        // when
        String[] split = value.split(",");

        // then
        assertThat(split).containsExactly("1", "2");
    }

    @Test
    @DisplayName("1을 ,로 split -> 1 리턴")
    void split_test_2() {
        // given
        String value = "1";

        // when
        String[] split = value.split(",");

        // then
        assertThat(split).contains("1");
    }

    /*
     * 요구사항
     * "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 "1,2"를 반환하도록 구현한다.
     * */

    @Test
    @DisplayName("(1,2)에서 String substring()를 활용해 괄호 제거 -> 1,2 반환")
    void substring_test() {
        // given
        String value = "(1,2)";

        // when
        String substring = value.substring(1, value.length() - 1);

        // then
        assertThat(substring).isEqualTo("1,2");
    }

    /*
    * 요구사항
    * "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습테스트를 구현한다.
    * String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면
    * StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
    * JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
    * */

    @Test
    @DisplayName("abc를 String charAt()을 활용해 특정 위치 문자 가져오기")
    void charAt_test() {
        // given
        String value = "abc";

        // when
        char c0 = value.charAt(0);
        char c1 = value.charAt(1);
        char c2 = value.charAt(2);

        // then
        assertThat(c0).isEqualTo('a');
        assertThat(c1).isEqualTo('b');
        assertThat(c2).isEqualTo('c');

    }

    @Test
    @DisplayName("abc를 String charAt()을 활용해 특정 위치 문자 가져오기")
    void charAt_exception_test() {
        // given
        String value = "abc";

        // when
        // then
        assertThatThrownBy(() -> {
            value.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
