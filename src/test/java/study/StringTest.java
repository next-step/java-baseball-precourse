package study;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("1,2를 ','로 split했을 때 1과 2로 분리되어야 한다.")
    void split1() {
        String testStr = "1,2";

        assertThat(testStr.split(",")).containsOnly("1", "2");
    }

    @Test
    @DisplayName("1을 ','로 split했을 때 1만을 포함하는 배열이 반환되어야 한다.")
    void split2() {
        String testStr = "1";

        assertThat(testStr.split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("(1,2)값이 주어졌을 때 ()를 제거하고 1,2를 반환해야한다.")
    void substring() {
        String testStr = "(1,2)";

        assertThat(testStr.substring(1, testStr.length() - 1)).isEqualTo("1,2");
    }

    @ParameterizedTest
    @CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
    @DisplayName("abc값이 주어지면 특정 위치의 문자를 가져와야 한다.")
    void charAt(int inputIndex, char expected) {
        String testStr = "abc";

        assertThat(testStr.charAt(inputIndex)).isEqualTo(expected);
    }

    @Test
    @DisplayName("특정 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    void charAt() {
        String testStr = "abc";

        ThrowableAssert.ThrowingCallable outOfPosition = () -> testStr.charAt(3);

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(outOfPosition)
                .withMessageMatching("String index out of range: 3");
    }
}
