package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class NumberTest {

    @Test
    void 입력값이_세자릿수_미만인_경우_예외를_던진다() {
        Throwable throwable = catchThrowable(() -> new Number("12"));
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자의 길이가 올바르지 않습니다");
    }

    @Test
    void 입력값이_세자릿수_초과인_경우_예외를_던진다() {
        Throwable throwable = catchThrowable(() -> new Number("1234"));
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자의 길이가 올바르지 않습니다");
    }

    @Test
    void 입력값에_중복된_숫자가_있는_경우_예외를_던진다() {
        Throwable throwable = catchThrowable(() -> new Number("131"));
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 숫자가 존재합니다");
    }
}