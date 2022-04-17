package baseball;

import baseball.balls.BallNumber;
import baseball.utils.ValidationUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;

public class ValidationTest {

    @Test
    @DisplayName("입력 값의 길이 3 검증")
    void test01() {
        assertThat(ValidationUtils.validateLength(1, ValidationUtils.FIXED_LENGTH)).isFalse();
        assertThat(ValidationUtils.validateLength(100, ValidationUtils.FIXED_LENGTH)).isTrue();
        assertThat(ValidationUtils.validateLength(999, ValidationUtils.FIXED_LENGTH)).isTrue();
        assertThat(ValidationUtils.validateLength(9999, ValidationUtils.FIXED_LENGTH)).isFalse();
    }

    @Test
    @DisplayName("입력 값이 1 ~ 9 범위의 숫자 검증")
    void test02() {
        assertThat(ValidationUtils.validateNumberRange(0, BallNumber.MIN_NUMBER, BallNumber.MAX_NUMBER)).isFalse();
        assertThat(ValidationUtils.validateNumberRange(1, BallNumber.MIN_NUMBER, BallNumber.MAX_NUMBER)).isTrue();
        assertThat(ValidationUtils.validateNumberRange(9, BallNumber.MIN_NUMBER, BallNumber.MAX_NUMBER)).isTrue();
        assertThat(ValidationUtils.validateNumberRange(10, BallNumber.MIN_NUMBER, BallNumber.MAX_NUMBER)).isFalse();
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

    @Test
    @DisplayName("숫자만 입력 검증")
    void test04() {
        assertThat(ValidationUtils.isNumeric("111")).isTrue();
        assertThat(ValidationUtils.isNumeric("11r")).isFalse();
        assertThat(ValidationUtils.isNumeric("asd")).isFalse();
        assertThat(ValidationUtils.isNumeric("11.1")).isFalse();
    }
}
