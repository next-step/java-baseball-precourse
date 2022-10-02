package baseball.domain.number;

import baseball.contant.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballNumbersTest {

    @Test
    @DisplayName("Empty List로 BaseballNumbers 생성 시 예외 발생")
    void generateBaseballNumbersExceptionTest1() {
        // given
        BaseballNumbersGenerator generator = new BaseballNumbersGenerator(new EmptyNumberGenerateStrategy());

        // when, then
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> BaseballNumbers.from(generator.generate()))
                .withMessageContaining(ExceptionMessage.INVALID_BASEBALL_NUMBERS_SIZE);
    }

    @Test
    @DisplayName("3자리 수가 넘는 BaseballNumbers 생성 시 예외 발생")
    void generateBaseballNumbersExceptionTest2() {
        // given
        BaseballNumbersGenerator generator = new BaseballNumbersGenerator(new OverNumberGenerateStrategy());

        // when, then
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> BaseballNumbers.from(generator.generate()))
                .withMessageContaining(ExceptionMessage.INVALID_BASEBALL_NUMBERS_SIZE);
    }

    @Test
    @DisplayName("3자리 수로 BaseballNumbers 생성")
    void generateBaseballNumbersTest() {
        // given
        BaseballNumbersGenerator generator = new BaseballNumbersGenerator(new DefaultNumberGenerateStrategy());

        // when
        BaseballNumbers baseballNumbers = BaseballNumbers.from(generator.generate());

        // then
        Assertions.assertThat(baseballNumbers.size()).isEqualTo(3);
    }
}