package baseball.domain.rule;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.result.DefaultResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BallRuleTest {

    Rule rule = new BallRule();

    @ParameterizedTest
    @DisplayName("원_볼")
    @CsvSource(value = {"123:451"}, delimiter = ':')
    void one_ball(String input, String randomValue) {
        int result = rule.count(input, randomValue, new DefaultResult());
        assertThat(result).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("투_볼")
    @CsvSource(value = {"123:351"}, delimiter = ':')
    void two_ball(String input, String randomValue) {
        int result = rule.count(input, randomValue, new DefaultResult());
        assertThat(result).isEqualTo(2);
    }

    @ParameterizedTest
    @DisplayName("쓰리_볼")
    @CsvSource(value = {"123:312"}, delimiter = ':')
    void three_ball(String input, String randomValue) {
        int result = rule.count(input, randomValue, new DefaultResult());
        assertThat(result).isEqualTo(3);
    }
}