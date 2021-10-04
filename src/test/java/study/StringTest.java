package study;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {

    @Test
    @DisplayName("정상적으로 분리된 배열이 반환되는지 확인")
    void checkMultiValueSplit() {
        // given
        String offerStr = "1,2";
        String separator = ",";

        // when
        String[] result = offerStr.split(separator);

        // then
        assertAll(
                () -> assertThat(result).isNotEmpty(),
                () -> assertThat(result).isInstanceOf(String[].class),
                () -> assertThat(result).containsExactly("1", "2")
        );
    }

    @Test
    @DisplayName("정의한 구분자가 포함되어 있지 않은 문자열을 분리하였을 때 기대값을 가진 배열이 반환되는지 확인")
    void checkSingleValueSplit() {
        // given
        String offerStr = "1";
        String separator = ",";

        // when
        String[] result = offerStr.split(separator);

        // then
        assertAll(
                () -> assertThat(result).isNotEmpty(),
                () -> assertThat(result).isInstanceOf(String[].class),
                () -> assertThat(result).containsExactly("1")
        );
    }

    @Test
    @DisplayName("괄호가 제거된 문자열이 반환되는지 확인")
    void checkRemovalBracket() {
        //given
        String offerStr = "(1,2)";

        // when
        String result = offerStr.substring(1, offerStr.length() - 1);

        // then
        assertAll(
                () -> assertThat(result).isNotNull(),
                () -> assertThat(result).isInstanceOf(String.class),
                () -> assertThat(result).isEqualTo("1,2")
        );

    }

    @ParameterizedTest(name = "위치 값이 {0} 일때, 기대한 문자 {1} 가 올바르게 반환되는지 확인")
    @CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
    void checkSpecificPositionalCharacter(Integer index, Character expectChar) {
        // given // when
        String offerStr = "abc";

        // then
        assertAll(
                () -> assertThat(offerStr).isInstanceOf(String.class),
                () -> assertThat(offerStr.charAt(index)).isEqualTo(expectChar)
        );
    }

    @Test
    @DisplayName("비정상적인 위치값을 입력할 경우 기대한 예외가 발생하는지 확인")
    void checkStringIndexOutOfBoundsException() {
        // given
        String offerStr = "abc";

        // then
        assertThatThrownBy(() -> offerStr.charAt(offerStr.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range:");
    }
}
