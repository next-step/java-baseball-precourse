package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {
    @Test
    @DisplayName("숫자 길이 테스트")
    void checkInputLength() {
        String str = "1";
        Validation validation = new Validation(3);

        assertThatThrownBy(() -> validation.validateInputData(str))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자여부(문자열 및 0여부(숫자범위1~9) 테스트")
    void checkCharAndZero() {
        String str1 = "12I";
        Validation validation = new Validation(3);

        assertThatThrownBy(() -> validation.validateInputData(str1))
                .isInstanceOf(IllegalArgumentException.class);

        String str2 = "103";
        assertThatThrownBy(() -> validation.validateInputData(str2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복된 숫자 체크 테스트")
    void checkDuplicateNumber() {
        String str = "122";
        Validation validation = new Validation(3);

        assertThatThrownBy(() -> validation.validateInputData(str))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
