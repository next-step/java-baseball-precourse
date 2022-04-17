package baseball.util;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ValidationUtilsTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "9", "10", "123", "1234"})
    void 입력된문자열이_숫자이어야만한다(String input) {
        assertTrue(ValidationUtils.isOnlyNumber(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1s", "1!", "s1", "s1s"})
    void 입력된문자열이_숫자만있는것이아니다(String input) {
        assertFalse(ValidationUtils.isOnlyNumber(input));
    }
}