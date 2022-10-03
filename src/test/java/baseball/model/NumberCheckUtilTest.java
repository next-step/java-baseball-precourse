package baseball.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumberCheckUtilTest {
    @Test
    void 입력값_길이_체크_테스트() {
        // 길이가 3인 경우
        assertThat(NumberCheckUtil.isValid("123")).isTrue();
        // 길이가 맞지 않은 경우
        assertThatIllegalArgumentException().isThrownBy(() -> NumberCheckUtil.isValid("1234"));
        assertThatIllegalArgumentException().isThrownBy(() -> NumberCheckUtil.isValid("12"));
        assertThatIllegalArgumentException().isThrownBy(() -> NumberCheckUtil.isValid("3"));
    }

    @Test
    void 입력값_유효한_문자인지_체크_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> NumberCheckUtil.isValid("abc"));
        assertThatIllegalArgumentException().isThrownBy(() -> NumberCheckUtil.isValid("abc efg"));
        assertThatIllegalArgumentException().isThrownBy(() -> NumberCheckUtil.isValid("가나다"));
    }

    @Test
    void 입력값_중복된_문자_체크_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> NumberCheckUtil.isValid("111"));
        assertThatIllegalArgumentException().isThrownBy(() -> NumberCheckUtil.isValid("334"));
    }
}