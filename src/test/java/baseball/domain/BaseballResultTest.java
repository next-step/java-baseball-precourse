package baseball.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BaseballResultTest {

    @Test
    void 스트라이크_3개() {
        List<Integer> inputNumbers = Lists.list(1, 2, 3);
        List<Integer> baseballNumbers = Lists.list(1, 2, 3);

        Score match = BaseballResult.match(inputNumbers, baseballNumbers);

        assertThat(match.getStrike()).isEqualTo(3);
    }

    @Test
    void 스트라이크1개_볼2개() {
        List<Integer> inputNumbers = Lists.list(1, 2, 4);
        List<Integer> baseballNumbers = Lists.list(1, 4, 2);

        Score match = BaseballResult.match(inputNumbers, baseballNumbers);

        assertTrue(match.getStrike() == 1 && match.getBall() == 2);
    }
}