package baseball.domain.generator;

import baseball.constant.BaseballConfig;
import baseball.constant.BaseballMessages;
import baseball.domain.BaseballNumberConfig;
import baseball.util.NumberUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RandomNumberGeneratorTest {
    @RepeatedTest(value = 10, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("1부터 9까지 서로 다른 수로 이루어진 3자리의 수 생성")
    void generateNumbers() {
        // given
        int startRandomNumber = BaseballConfig.START_RANDOM_NUMBER;
        int endRandomNumber = BaseballConfig.END_RANDOM_NUMBER;
        int numberCount = BaseballConfig.NUMBER_COUNT;
        BaseballNumberConfig config = new BaseballNumberConfig(startRandomNumber,
                                                               endRandomNumber,
                                                               numberCount);
        NumberGenerator numberGenerator = new RandomNumberGenerator(config);

        // when
        List<Integer> numbers = numberGenerator.generateNumbers();

        // then
        assertThat(numbers).hasSize(numberCount);
        assertThat(numbers.get(0)).isNotEqualTo(numbers.get(1));
        assertThat(numbers.get(1)).isNotEqualTo(numbers.get(2));
    }

    @Test
    @DisplayName("발생시킬 임의의 수의 개수가 범위의 모든 수의 개수를 초과하면 IllegalArgumentException 발생")
    void generateNumbersThrows() {
        // given
        int startRandomNumber = BaseballConfig.START_RANDOM_NUMBER;
        int endRandomNumber = BaseballConfig.END_RANDOM_NUMBER;
        int numberCount = 10;

        // when
        Throwable exception = assertThrows(IllegalArgumentException.class,
                                           () -> NumberUtil.pickUniqueNumbers(startRandomNumber,
                                                                              endRandomNumber,
                                                                              numberCount));
        String message = exception.getMessage();

        // then
        assertThat(message).isEqualTo(BaseballMessages.ERROR_OVERFLOW_RANDOM_NUMBER_COUNT);
    }
}
