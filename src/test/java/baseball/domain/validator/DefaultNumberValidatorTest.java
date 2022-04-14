package baseball.domain.validator;

import baseball.constant.BaseballConfig;
import baseball.constant.BaseballMessages;
import baseball.domain.BaseballNumberConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DefaultNumberValidatorTest {
    private final BaseballNumberConfig numberConfig = new BaseballNumberConfig(BaseballConfig.START_RANDOM_NUMBER,
                                                                               BaseballConfig.END_RANDOM_NUMBER,
                                                                               BaseballConfig.NUMBER_COUNT);

    @Test
    @DisplayName("숫자 유효성 확인 - 정상")
    void validate() {
        // given
        NumberValidator validator = new DefaultNumberValidator(numberConfig);
        List<Integer> numbers = Arrays.asList(1, 2, 3);

        // when
        Boolean validation = assertDoesNotThrow(() -> {
            validator.validate(numbers);
            return true;
        });

        // then
        assertThat(validation).isEqualTo(Boolean.TRUE);
    }

    @Test
    @DisplayName("숫자 유효성 확인 - 숫자 개수가 3개가 아니면 예외 발생")
    void validateSize() {
        // given
        NumberValidator validator = new DefaultNumberValidator(numberConfig);
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        // when
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> validator.validate(numbers));
        String message = exception.getMessage();

        // then
        assertThat(message).isEqualTo(String.format(BaseballMessages.ERROR_NUMBER_COUNT, numberConfig.getNumberCount()));
    }

    @Test
    @DisplayName("숫자 유효성 확인 - 숫자 범위가 1 ~ 9가 아니면 예외 발생")
    void validateRange() {
        // given
        NumberValidator validator = new DefaultNumberValidator(numberConfig);
        List<Integer> numbers = Arrays.asList(1, 2, 10);

        // when
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> validator.validate(numbers));
        String message = exception.getMessage();

        // then
        assertThat(message).isEqualTo(
                String.format(BaseballMessages.ERROR_NUMBER_RANGE, numberConfig.getStartRandomNumber(), numberConfig.getEndRandomNumber()));
    }

    @Test
    @DisplayName("숫자 유효성 확인 - 숫자가 중복되면 예외 발생")
    void validateUnique() {
        // given
        NumberValidator validator = new DefaultNumberValidator(numberConfig);
        List<Integer> numbers = Arrays.asList(1, 2, 2);

        // when
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> validator.validate(numbers));
        String message = exception.getMessage();

        // then
        assertThat(message).isEqualTo(BaseballMessages.ERROR_NUMBER_DUPLICATE);
    }
}
