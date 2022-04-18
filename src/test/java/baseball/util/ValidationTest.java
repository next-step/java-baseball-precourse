package baseball.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationTest {
    @Test
    void 길이_테스트() {
        String str = "12";
        Validation validation = new Validation(3);

        assertThatThrownBy(() -> validation.validateInputData(str))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자열_0_테스트() {
        String str1 = "12I";
        Validation validation = new Validation(3);

        assertThatThrownBy(() -> validation.validateInputData(str1))
                .isInstanceOf(IllegalArgumentException.class);

        String str2 = "103";
        assertThatThrownBy(() -> validation.validateInputData(str2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자열_중복체크() {
        String str = "122";
        Validation validation = new Validation(3);

        assertThatThrownBy(() -> validation.validateInputData(str))
                .isInstanceOf(IllegalArgumentException.class);
    }

}