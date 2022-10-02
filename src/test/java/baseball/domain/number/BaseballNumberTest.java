package baseball.domain.number;

import baseball.contant.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballNumberTest {

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:false"}, delimiter = ':')
    @DisplayName("BaseballNumber 객체 동등성 테스트")
    void equalsTest(int number, boolean expected) {
        // given
        BaseballNumber baseballNumber1 = BaseballNumber.from(1);
        BaseballNumber baseballNumber2 = BaseballNumber.from(number);

        // when
        boolean result = baseballNumber1.equals(baseballNumber2);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 10})
    @DisplayName("1 ~ 9 이외 숫자로  BaseballNumber 객체 생성 시 예외 발생")
    void generateBaseballNumberExceptionTest(int number) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> BaseballNumber.from(number))
                .withMessageContaining(ExceptionMessage.INVALID_BASEBALL_NUMBER);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    @DisplayName("1 ~ 9 숫자로 BaseballNumber 객체 생성")
    void generateBaseballNumber(int number) {
        // given
        BaseballNumber baseballNumber = BaseballNumber.from(number);

        // when
        int result = baseballNumber.number();

        // then
        Assertions.assertThat(result).isEqualTo(number);
    }
}