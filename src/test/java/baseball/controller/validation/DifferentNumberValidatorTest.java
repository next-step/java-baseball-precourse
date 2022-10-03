package baseball.controller.validation;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DifferentNumberValidatorTest {

    Validator validator = new DifferentNumberValidator();

    @ParameterizedTest
    @DisplayName("입력 받은 값이 서로다른 숫자인가")
    @CsvSource(value = {"131:123"}, delimiter = ':')
    void checkDifferentNumber(String ex, String success) {
        assertThatIllegalArgumentException().isThrownBy(() -> validator.check(ex))
                .withMessage(Validator.ERROR_MESSAGE);
        assertThatNoException().isThrownBy(() -> validator.check(success));
    }

}