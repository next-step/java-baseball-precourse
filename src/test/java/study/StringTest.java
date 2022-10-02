package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @DisplayName("구분자가 포함된 숫자 텍스트를 split 메서드로 분리 했을 때 분리된 배열이 반환된다")
    @Test
    void whenSplitNumberText_thenReturnNumberArray() {
        // given
        final String REGEX = ",";

        // when
        String[] numbers1 = "1,2".split(REGEX);
        String[] numbers2 = "1".split(REGEX);
        String[] numbers3 = "10,5,2,4".split(REGEX);

        // then
        assertThat(numbers1).containsExactly("1", "2");
        assertThat(numbers2).containsExactly("1");
        assertThat(numbers3).contains("2", "4", "5", "10");
    }

    @DisplayName("괄호로 감싸진 구분자가 포함된 숫자 텍스트에서 substring 메서드를 통해 괄호를 제거한다")
    @Test
    void whenSubstringNumberTextWithBracket_thenRemoveBracket() {
        // given
        String inputText1 = "(1,2)";
        String inputText2 = "(50)";

        // when
        String resultText1 = inputText1.substring(1, inputText1.length() - 1);
        String resultText2 = inputText2.substring(1, inputText2.length() - 1);

        // then
        assertThat(resultText1).isEqualTo("1,2");
        assertThat(resultText2).isEqualTo("50");
    }

    @ParameterizedTest
    @CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
    @DisplayName("charAt 메서드를 사용해 특정 위치의 문자를 가져온다")
    void whenUsingCharAtForText_thenGetCharFromSpecificPosition(int index, char expected) {
        // given
        String inputText = "abc";

        // when
        // then
        assertThat(inputText.charAt(index)).isEqualTo(expected);
    }

    @DisplayName("charAt 메서드를 사용할 때 index 범위를 벗어나면 에러가 발생한다")
    @Test
    void whenUsingCharAtForTextIfIndexOutOfRange_thenThrowException() {
        // given
        String inputText = "abc";

        // when
        // then
        assertThatThrownBy(() -> inputText.charAt(3)).isInstanceOf(IndexOutOfBoundsException.class)
                                                     .hasMessage("String index out of range: 3");
    }
}
