package baseball.controller.validation;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RangeValidatorTest {

    Validator validator = new RangeValidator();

    @ParameterizedTest
    @DisplayName("입력 받은 값이 1-9 사이에 포함되는가")
    @CsvSource(value = {"1이3:123"}, delimiter = ':')
    void checkRange(String ex, String success) {
        assertThatIllegalArgumentException().isThrownBy(() -> validator.check(ex))
                .withMessage(Validator.ERROR_MESSAGE);
        assertThatNoException().isThrownBy(() -> validator.check(success));
    }
}