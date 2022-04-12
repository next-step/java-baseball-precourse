package baseball.domain;

import baseball.constant.BaseballMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.ThrowingSupplier;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BaseballNumberValidatorTest {
    private static final int START_RANDOM_NUMBER = 1;
    private static final int END_RANDOM_NUMBER = 9;
    private static final int NUMBER_COUNT = 3;

    @Test
    @DisplayName("유효성 확인 - 정상")
    void validate() {
        // given
        BaseballNumberValidator validator = new BaseballNumberValidator(START_RANDOM_NUMBER,
                                                                        END_RANDOM_NUMBER,
                                                                        NUMBER_COUNT);
        List<Integer> numbers = Arrays.asList(1, 2, 3);

        // when
        ThrowingSupplier<Boolean> validate = () -> {
            validator.validate(numbers);
            return true;
        };

        // then
        assertDoesNotThrow(validate);
    }

    @Test
    @DisplayName("유효성 확인 - 숫자 개수가 3개가 아니면 예외 발생")
    void validateSize() {
        // given
        BaseballNumberValidator validator = new BaseballNumberValidator(START_RANDOM_NUMBER,
                                                                        END_RANDOM_NUMBER,
                                                                        NUMBER_COUNT);
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        // when
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> validator.validate(numbers));
        String message = exception.getMessage();

        // then
        assertThat(message).isEqualTo(String.format(BaseballMessages.ERROR_NUMBER_COUNT, NUMBER_COUNT));
    }

    @Test
    @DisplayName("유효성 확인 - 숫자 범위가 1 ~ 9가 아니면 예외 발생")
    void validateRange() {
        // given
        BaseballNumberValidator validator = new BaseballNumberValidator(START_RANDOM_NUMBER,
                                                                        END_RANDOM_NUMBER,
                                                                        NUMBER_COUNT);
        List<Integer> numbers = Arrays.asList(1, 2, 10);

        // when
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> validator.validate(numbers));
        String message = exception.getMessage();

        // then
        assertThat(message).isEqualTo(
                String.format(BaseballMessages.ERROR_NUMBER_RANGE, START_RANDOM_NUMBER, END_RANDOM_NUMBER));
    }

    @Test
    @DisplayName("유효성 확인 - 숫자가 중복되면 예외 발생")
    void validateUnique() {
        // given
        BaseballNumberValidator validator = new BaseballNumberValidator(START_RANDOM_NUMBER,
                                                                        END_RANDOM_NUMBER,
                                                                        NUMBER_COUNT);
        List<Integer> numbers = Arrays.asList(1, 2, 2);

        // when
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> validator.validate(numbers));
        String message = exception.getMessage();

        // then
        assertThat(message).isEqualTo(BaseballMessages.ERROR_NUMBER_DUPLICATE);
    }
}
