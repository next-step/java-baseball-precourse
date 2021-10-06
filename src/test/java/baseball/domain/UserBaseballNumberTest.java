package baseball.domain;

import baseball.exception.BaseballException;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class UserBaseballNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"1a2", "012", "asd", "12^", "qqf3w4q5qf"})
    @DisplayName("1부터 9사이의 숫자가 아니면 IllegalArgumentException이 발생한다")
    void not_1_9_error(String input) {
        UserBaseballNumber userBaseballNumber = new UserBaseballNumber(input);
        ThrowableAssert.ThrowingCallable validation = () -> userBaseballNumber.validate();

        assertThatExceptionOfType(BaseballException.class)
                .isThrownBy(validation);
    }

    @Test
    @DisplayName("길이가 3자리 이상이면 IllegalArgumentException이 발생한다")
    void three_length_error() {
        String input = "1234";
        UserBaseballNumber userBaseballNumber = new UserBaseballNumber(input);
        ThrowableAssert.ThrowingCallable validation = () -> userBaseballNumber.validate();

        assertThatExceptionOfType(BaseballException.class)
                .isThrownBy(validation);
    }

    @Test
    @DisplayName("중복된 값이면 IllegalArgumentException이 발생한다")
    void input_error() {
        String input = "121";

        UserBaseballNumber userBaseballNumber = new UserBaseballNumber(input);

        ThrowableAssert.ThrowingCallable validation = () -> userBaseballNumber.validate();

        assertThatExceptionOfType(BaseballException.class)
                .isThrownBy(validation);
    }
}
