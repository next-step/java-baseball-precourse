package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputUtilTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "a1", "a1a"})
    @DisplayName("숫자가 아닌 값이 입력되면 IllegalArgumentException 발생")
    void invalidNumberFormatTest(String input) {
        assertThatThrownBy(() -> InputUtil.getUserNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", "1", "12", "12345"})
    @DisplayName("3자리가 아닌 값이 입력되면 IllegalArgumentException 발생")
    void invalidNumberLengthTest(String input) {
        assertThatThrownBy(() -> InputUtil.getUserNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"112", "111", "122"})
    @DisplayName("중복된 숫자가 입력되면 IllegalArgumentException 발생")
    void duplicateTest(String input) {
        assertThatThrownBy(() -> InputUtil.getUserNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상적인 입력값이 들어오면 세 개의 숫자를 가진 배열 반환")
    void getNumbersTest() {
        // given
        String input = "123";

        // when
        List<Integer> userNumbers = InputUtil.getUserNumbers(input);

        // then
        assertThat(userNumbers)
                .containsExactly(1, 2, 3)
                .hasSize(3);
    }

}