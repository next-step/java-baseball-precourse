package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

class RuleTest {

    @DisplayName("횟수와 룰 이름을 가진 문자를 생성한다.")
    @ParameterizedTest
    @EnumSource(value = Rule.class)
    void create(Rule rule) {
        assertThat(rule.getText(1)).isEqualTo("1" + rule.getName());
    }
}