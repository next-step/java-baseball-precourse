package baseball.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputNumberValidatorTest {

    @Test
    @DisplayName("입력_숫자_테스트")
    void 입력_숫자_테스트() {
        InputNumberValidator inputNumberValidator = new InputNumberValidator();
        assertThat(inputNumberValidator.validateInput("234")).isTrue();
        assertThatThrownBy(() -> inputNumberValidator.validateInput("012"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputNumberValidator.validateInput("121"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputNumberValidator.validateInput("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
