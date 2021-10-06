package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class InputValidatorTest {
    @ParameterizedTest
    @CsvSource(value = {"1234,false", "123,true", "876,true", "acxf,false", "ffff,false", "*^&^%,false", "1,false", "21,false", "!113887,false"}, delimiter = ',')
    void 입력값이_3자리인지_판별한다(String input, boolean expected) {
        Assertions.assertThat(new InputValidator().validateLength(input.split(""))).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "3,true", "5,true", "9,true", "0,false", "10,false"}, delimiter = ',')
    void 입력된_정수값이_유효한_범위로_이루어져_있는지_판별한다(int num, boolean expected) {
        Assertions.assertThat(new InputValidator().validateRange(num)).isEqualTo(expected);
    }
}
