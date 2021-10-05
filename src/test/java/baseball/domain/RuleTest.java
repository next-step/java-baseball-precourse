package baseball.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

class RuleTest {

    @ParameterizedTest
    @EnumSource(value = Rule.class)
    void create(Rule rule) {
        assertThat(rule.toString(1)).isEqualTo("1" + rule.getName());
    }
}