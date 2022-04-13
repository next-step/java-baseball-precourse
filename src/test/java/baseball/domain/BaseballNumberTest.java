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

class BaseballNumberTest {
    private static final int START_RANDOM_NUMBER = 1;
    private static final int END_RANDOM_NUMBER = 9;
    private static final int NUMBER_COUNT = 3;

    private final BaseballNumberValidator validator = new BaseballNumberValidator(START_RANDOM_NUMBER,
                                                                                  END_RANDOM_NUMBER,
                                                                                  NUMBER_COUNT);

    @Test
    @DisplayName("숫자 객체 생성 및 유효성 확인")
    void test() {
        // given
        BaseballNumber baseballNumber = new BaseballNumber(validator);
        List<Integer> numbers = Arrays.asList(1, 2, 3);

        // when
        ThrowingSupplier<Boolean> validate = () -> {
            baseballNumber.setNumbers(numbers);
            return true;
        };

        // then
        assertDoesNotThrow(validate);
        assertThat(baseballNumber.get(0)).isEqualTo(1);
        assertThat(baseballNumber.get(1)).isEqualTo(2);
        assertThat(baseballNumber.get(2)).isEqualTo(3);
    }

    @Test
    @DisplayName("숫자 객체 생성 및 유효성 확인 - 숫자 개수가 3개가 아니면 예외 발생")
    void validateSize() {
        // given
        BaseballNumber baseballNumber = new BaseballNumber(validator);
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        // when
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> baseballNumber.setNumbers(numbers));
        String message = exception.getMessage();

        // then
        assertThat(message).isEqualTo(String.format(BaseballMessages.ERROR_NUMBER_COUNT, NUMBER_COUNT));
    }

    @Test
    @DisplayName("숫자 객체 생성 및 유효성 확인 - 숫자 범위가 1 ~ 9가 아니면 예외 발생")
    void validateRange() {
        // given
        BaseballNumber baseballNumber = new BaseballNumber(validator);
        List<Integer> numbers = Arrays.asList(1, 2, 10);

        // when
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> baseballNumber.setNumbers(numbers));
        String message = exception.getMessage();

        // then
        assertThat(message).isEqualTo(
                String.format(BaseballMessages.ERROR_NUMBER_RANGE, START_RANDOM_NUMBER, END_RANDOM_NUMBER));
    }

    @Test
    @DisplayName("숫자 객체 생성 및 유효성 확인 - 숫자가 중복되면 예외 발생")
    void validateUnique() {
        // given
        BaseballNumber baseballNumber = new BaseballNumber(validator);
        List<Integer> numbers = Arrays.asList(1, 2, 2);

        // when
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> baseballNumber.setNumbers(numbers));
        String message = exception.getMessage();

        // then
        assertThat(message).isEqualTo(BaseballMessages.ERROR_NUMBER_DUPLICATE);
    }
}
