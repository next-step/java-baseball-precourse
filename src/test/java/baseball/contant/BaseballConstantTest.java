package baseball.contant;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BaseballConstantTest {

    @ParameterizedTest
    @CsvSource(
            value = {"123:true", "111:true", "1234:false", "1:false", "0:false", "!@#:false", "12a:false", "abc:false"},
            delimiter = ':'
    )
    @DisplayName("1~9 숫자로 이루어진 3자리 수 확인")
    void test1(String input, boolean expected) {
        Assertions.assertThat(input.matches(BaseballConstant.INPUT_USER_NUMBERS_REG_EXP)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:false", "ab:false", "12:false"}, delimiter = ':')
    @DisplayName("1 또는 2만 필터링 되는지 확인")
    void test2(String input, boolean expected) {
        Assertions.assertThat(input.matches(BaseballConstant.INPUT_CONTINUE_REG_EXP)).isEqualTo(expected);
    }
}