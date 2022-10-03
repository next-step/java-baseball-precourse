package baseball.domain.rule;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.result.DefaultResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StrikeRuleTest {

    Rule rule = new StrikeRule();

    @ParameterizedTest
    @DisplayName("원_스트라이크")
    @CsvSource(value = {"123:453"}, delimiter = ':')
    void one_strike(String input, String randomValue) {
        int result = rule.count(input, randomValue, new DefaultResult());
        assertThat(result).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("투_스트라이크")
    @CsvSource(value = {"123:423"}, delimiter = ':')
    void two_strike(String input, String randomValue) {
        int result = rule.count(input, randomValue, new DefaultResult());
        assertThat(result).isEqualTo(2);
    }

    @ParameterizedTest
    @DisplayName("쓰리_스트라이크")
    @CsvSource(value = {"123:123"}, delimiter = ':')
    void three_strike(String input, String randomValue) {
        int result = rule.count(input, randomValue, new DefaultResult());
        assertThat(result).isEqualTo(3);
    }
}