package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    private final String splitText = ",";

    /**
     * "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
     */
    @Test
    @DisplayName("문자_두개_분리")
    void 문자_두개_분리(){
        final String[] solution = {"1", "2"};
        assertThat( "1,2".split(splitText))
                .isNotEmpty()
                .doesNotContainNull()
                .containsExactly("1", "2")
                .isEqualTo(solution);
    }

    /**
     * "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
     */
    @Test
    @DisplayName("문자_하나_분리")
    void 문자_하나_분리(){
        final String[] solution = {"1"};
        assertThat( "1".split(splitText))
                .isNotEmpty()
                .hasSize(1)
                .doesNotContainNull()
                .containsExactly("1")
                .isEqualTo(solution);
    }

    /**
     * "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 "1,2"를 반환하도록 구현한다.
     */
    @Test
    @DisplayName("괄호_문자_제거")
    void 괄호_문자_제거(){
        final String question = "(1,2)";
        final String solution = "1,2";

        assertThat(question.substring(1,4))
                .isNotBlank()
                .isEqualTo(solution);

        assertThat(question.substring(question.indexOf("(") + 1, question.lastIndexOf(")")))
                .isNotBlank()
                .isEqualTo(solution);
    }

    /**
     * "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습테스트를 구현한다.
     * String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
     * JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
     */
    @Test
    @DisplayName("특정_위치_문자_조회")
    void 특정_위치_문자_조회(){
        final String question = "abc";

        assertThat(question.charAt(0))
                .isEqualTo('a');
        assertThat(question.charAt(1))
                .isEqualTo('b');
        assertThat(question.charAt(2))
                .isEqualTo('c');

        assertThatThrownBy(() -> assertThat(question.charAt(3)))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> assertThat(question.charAt(3)))
                .withMessageMatching("String index out of range: \\d+");
    }

    @ParameterizedTest
    @ValueSource(chars = {'a', 'b', 'c'})
    @DisplayName("특정_위치_문자_조회_중복_코드_제거")
    void 특정_위치_문자_조회_중복_코드_제거(char input){
        final String question = "abc";

        assertThat(question.toCharArray()).contains(input);
    }
}
