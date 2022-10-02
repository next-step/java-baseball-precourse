package baseball.controller;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class BaseballGameUserInputValidatorTest {

    @Test
    void validateUserNumberInputTest() {
        assertAll(() -> BaseballGameUserInputValidator.validateUserNumberInput(
                "123", 3
        ));
        assertThatIllegalArgumentException().isThrownBy(
                () -> BaseballGameUserInputValidator.validateUserNumberInput("123", 1)
        );
        assertThatIllegalArgumentException().isThrownBy(
                () -> BaseballGameUserInputValidator.validateUserNumberInput("123", 2)
        );
        assertThatIllegalArgumentException().isThrownBy(
                () -> BaseballGameUserInputValidator.validateUserNumberInput("qqq", 3)
        );
    }

    @Test
    void validateRestartCommandTest() {
        assertAll(() -> BaseballGameUserInputValidator.validateRestartCommand(1));
        assertAll(() -> BaseballGameUserInputValidator.validateRestartCommand(2));
        assertThatIllegalArgumentException().isThrownBy(
                () -> BaseballGameUserInputValidator.validateRestartCommand(0)
        );
        assertThatIllegalArgumentException().isThrownBy(
                () -> BaseballGameUserInputValidator.validateRestartCommand(3)
        );
        assertThatIllegalArgumentException().isThrownBy(
                () -> BaseballGameUserInputValidator.validateRestartCommand('q')
        );
    }
}
