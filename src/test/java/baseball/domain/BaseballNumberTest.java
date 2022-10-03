package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class BaseballNumberTest {
    
    @ParameterizedTest(name = "num1: {0}, num2: {1}, expected: {2}")
    @CsvSource(value = {"1:1:true", "1:2:false", "3:3:true"}, delimiter = ':')
    @DisplayName("같은 값을 가진 두 BaseballNumber 객체를 비교한다.")
    void equals_baseballNumber_boolean(int number1, int number2, boolean expected) {        
        // when
        BaseballNumber baseballNumber1 = BaseballNumber.from(number1);
        BaseballNumber baseballNumber2 = BaseballNumber.from(number2);
        
        // then
        assertThat(baseballNumber1.equals(baseballNumber2))
                .isEqualTo(expected);
    }

    @ParameterizedTest(name = "number: {arguments}")
    @ValueSource(ints = {BaseballNumber.MAXIUM_NUMBER + 1, BaseballNumber.MINIMUM_NUMBER - 1})
    @DisplayName("지정된 범위 밖의 값으로 객체를 생성할 경우 에러를 반환한다.")
    void new_outOfRange_exception(int number) {
        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> BaseballNumber.from(number))
                .withMessageMatching(
                        ErrorMessage.BASEBALL_NUMBER_OUT_OF_RANGE_ERROR.getMessage().replace("%d", "\\d+"));
    }
}
