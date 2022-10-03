package baseball.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.exception.GameException;

class BallListValidatorTest {

    @Test
    @DisplayName("3자리 수가 아닌 경우에 대해 정상적으로 예외를 반환하는지 확인")
    void validateBallSize() {
        // given // when
        String inputOverSizeText = "1234";

        // then
        assertThatThrownBy(() -> BallListValidator.validateInputSize(inputOverSizeText))
                .isInstanceOf(GameException.class)
                .hasMessageContaining("Invalid ball list size");
    }

    @Test
    @DisplayName("숫자(1~0)가 아닌 다른 문자로 구성된 Ball List에 대해 정상적으로 예외를 반환하는지 확인")
    void validateBallValueType() {
        // given // when
        String inputText = "input";

        // then
        assertThatThrownBy(() -> BallListValidator.validateIsNumber(inputText))
                .isInstanceOf(GameException.class)
                .hasMessageContaining("Invalid ball value type");
    }

    @Test
    @DisplayName("중복된 수로 구성된 3자리 수에 대해 정상적으로 예외를 반환하는지 확인")
    void validateBallDuplicate() {
        // given // when
        String inputDuplicateBallList = "112";

        // then
        assertThatThrownBy(() -> BallListValidator.validateDuplicateNumber(inputDuplicateBallList))
                .isInstanceOf(GameException.class)
                .hasMessageContaining("Invalid ball duplicate");
    }
}
