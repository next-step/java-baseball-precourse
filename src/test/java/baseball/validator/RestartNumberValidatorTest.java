package baseball.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RestartNumberValidatorTest {

    @DisplayName("부정확한 숫자 검사")
    @ParameterizedTest
    @ValueSource(strings = {"3", "abc", "   ", "#$%", "long text", "012", "000", "12340", "---", "555"})
    public void check_exception_number_test(String test) {
        Validator validator = new RestartNumberValidator();
        assertThatThrownBy(() -> validator.valid(test)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 숫자 검사")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    public void check_exact_number_test(String test) {
        Validator validator = new RestartNumberValidator();
        assertThatCode(() -> validator.valid(test)).doesNotThrowAnyException();
    }
}
