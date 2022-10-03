package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringTest {
    @Test
    @DisplayName("1,2를 ,로 split 했을 때 배열 {1,2}로 분리된다.")
    void split_string_array() {
        // given
        String oneCommaTwo = "1,2";
        
        // when
        String[] splitedOneCommaTwo = oneCommaTwo.split(",");

        // then
        assertThat(splitedOneCommaTwo).contains("1", "2");
    }

    @Test
    @DisplayName("String 1을 ,로 split 했을 때 1만을 포함하는 배열이 반환된다.")
    void split_mismatchedRegex_array() {
        // given
        String one = "1";

        // when
        String[] splitedOne = one.split(",");

        // then
        assertThat(splitedOne).containsOnly("1");

    }

    @Test
    @DisplayName("String (1,2)를 1부터 4까지 subString 했을 때 1,2가 반환된다.")
    void substring_removeBracket_string() {
        // given 
        String OneAndTwo = "(1,2)";
        
        // when
        String subStringOneAndTwo = OneAndTwo.substring(1, 4);

        // then 
        assertThat(subStringOneAndTwo).isEqualTo("1,2");
    }

    @ParameterizedTest(name = "index: {0}, expected: {1}")
    @CsvSource(value = {"1:b", "2:c", "0:a"}, delimiter = ':')
    @DisplayName("charAt()을 String abc의 특정 위치 문자를 가져온다.")
    void charAt_char(int index, char expected) {
        // given
        String abc = "abc";

        // when
        char character = abc.charAt(index);

        // then
        assertThat(character).isEqualTo(expected);
    }

    @Test
    @DisplayName("charAt() 사용 시 위치 값을 벗어나면 에러가 발생한다.")
    void charAt_useIndexOutOfBounds_exception() {
        // given
        String abc = "abc";
        
        // when
        int index = abc.length();
        
        // then
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> abc.charAt(index))
                .withMessageMatching("String index out of range: \\d+");
    }
}   
