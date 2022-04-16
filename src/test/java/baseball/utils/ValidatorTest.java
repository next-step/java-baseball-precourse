package baseball.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    private Validator validator = new Validator();

    @ParameterizedTest
    @ValueSource(strings = {"12", "1234", "abc", "A", "1A2","000", "120", "191", "112", "121", "111"})
    void validInputNumberTest(String input) {
        assertThatThrownBy(() -> validator.validInputNumber(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "4", "15", "A", "aZ", "0"})
    void validExitTest(String input) {
        assertThatThrownBy(() -> validator.validExit(input)).isInstanceOf(IllegalArgumentException.class);
    }
}