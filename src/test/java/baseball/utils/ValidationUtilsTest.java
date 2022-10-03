package baseball.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class ValidationUtilsTest {

    @Test
    void 입력_3자리_여부() {
        assertThatThrownBy(() -> ValidationUtils.validate("1234")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3자리의 숫자만 입력가능합니다.");
    }

    @Test
    void 입력_숫자_여부() {
        assertThatThrownBy(() -> ValidationUtils.validate("가나다")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자(1~9)가 아닌 문자가 입력되었습니다.");
    }

    @Test
    void 입력_중복_여부() {
        assertThatThrownBy(() -> ValidationUtils.validate("111")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 숫자가 입력되었습니다.");
    }
}