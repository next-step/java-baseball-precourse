package baseball.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author KingCjy
 */
class ValidationUtilsTest {

    @ParameterizedTest
    @DisplayName("잘못된 입력(3자리가 아닌 숫자, 중복 숫자, 문자 여부, 0 존재여부)이 들어왔을 때 false 리턴 테스트")
    @ValueSource(strings = {"1923", "313", "가나1", "012"})
    public void isValidInputTest(String input) {
        boolean result = ValidationUtils.isValidInput(input);

        assertThat(result).isFalse();
    }
}