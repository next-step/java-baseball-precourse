package baseball.controller.validation;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LengthValidatorTest {

    Validator validator = new LengthValidator();

    @ParameterizedTest
    @DisplayName("입력 받은 값이 3자리 라면 통과, 아니라면 Ex발생")
    @CsvSource(value = {"1:123"}, delimiter = ':')
    void checkLength(String ex, String success) {
        assertThatIllegalArgumentException().isThrownBy(() -> validator.check(ex))
                .withMessage(Validator.ERROR_MESSAGE);
        assertThatNoException().isThrownBy(() -> validator.check(success));
    }
}