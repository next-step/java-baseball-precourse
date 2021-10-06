package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class StrikeTest {

    @DisplayName("스트라이크를 텍스트를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void text(int count) {
        Strike strike = new Strike(count);
        assertThat(strike.getText()).isEqualTo(count + Rule.STRIKE.getName());
    }

    @DisplayName("스트라이크가 0개인 경우 빈 텍스트를 생성한다.")
    @Test
    void text() {
        Strike strike = new Strike(0);
        assertThat(strike.getText()).isEmpty();
    }
}