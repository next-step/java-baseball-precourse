package baseball.util;

import baseball.common.Constants;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RandomUtilsTest {

    @Test
    void 중복되지않는_숫자를_생성해야한다() {
        List<Integer> randomNumbers = RandomUtils.generateNonRepeatRandomNumber(Constants.LIMIT_DIGITS);
        Map<Integer, Boolean> numberMap = new HashMap<>();

        for (Integer number : randomNumbers) {
            numberMap.put(number, true);
        }

        assertThat(numberMap.size()).isEqualTo(Constants.LIMIT_DIGITS);
    }
}