package baseball;

import baseball.utils.ValidationUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;

public class ValidationTest {

    @Test
    @DisplayName("입력 값의 길이 3 검증")
    void test01() {
        assertThat(ValidationUtils.validateLength(1)).isFalse();
        assertThat(ValidationUtils.validateLength(100)).isTrue();
        assertThat(ValidationUtils.validateLength(999)).isTrue();
        assertThat(ValidationUtils.validateLength(9999)).isFalse();
    }

    @Test
    @DisplayName("입력 값이 1 ~ 9 범위의 숫자 검증")
    void test02() {
        assertThat(ValidationUtils.validateNumber(0)).isFalse();
        assertThat(ValidationUtils.validateNumber(1)).isTrue();
        assertThat(ValidationUtils.validateNumber(9)).isTrue();
        assertThat(ValidationUtils.validateNumber(10)).isFalse();
    }

    @Test
    @DisplayName("입력 값 중복 검증")
    void test03() {
        assertThat(ValidationUtils.validateDuplication(111)).isFalse();
        assertThat(ValidationUtils.validateDuplication(113)).isFalse();
        assertThat(ValidationUtils.validateDuplication(123)).isTrue();
        assertThat(ValidationUtils.validateDuplication(122)).isFalse();
        assertThat(ValidationUtils.validateDuplication(193)).isTrue();
    }
}
