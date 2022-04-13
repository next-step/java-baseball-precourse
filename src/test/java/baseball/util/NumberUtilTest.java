package baseball.util;

import baseball.constant.BaseballMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberUtilTest {
    @RepeatedTest(value = 10, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("1부터 9까지 서로 다른 수로 이루어진 3자리의 수 생성")
    void pickUniqueNumbers() {
        // given
        int startRandomNumber = 1;
        int endRandomNumber = 9;
        int randomNumberSize = 3;

        // when
        List<Integer> numbers = NumberUtil.pickUniqueNumbers(startRandomNumber, endRandomNumber,
                                                             randomNumberSize);

        // then
        assertThat(numbers).hasSize(randomNumberSize);
        assertThat(numbers.get(0)).isNotEqualTo(numbers.get(1));
        assertThat(numbers.get(1)).isNotEqualTo(numbers.get(2));
    }

    @Test
    @DisplayName("발생시킬 임의의 수의 개수가 범위의 모든 수의 개수를 초과하면 IllegalArgumentException 발생")
    void pickOverflowNumbers() {
        // given
        int startRandomNumber = 1;
        int endRandomNumber = 9;
        int randomNumberSize = 10;

        // when
        Throwable exception = assertThrows(IllegalArgumentException.class,
                                           () -> NumberUtil.pickUniqueNumbers(startRandomNumber,
                                                                              endRandomNumber,
                                                                              randomNumberSize));
        String message = exception.getMessage();

        // then
        assertThat(message).isEqualTo(BaseballMessages.ERROR_OVERFLOW_RANDOM_NUMBER_COUNT);
    }
}
