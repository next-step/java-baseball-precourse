package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class BallTest {

    @DisplayName("볼 텍스트를 생성한다")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void text(int count) {
        Ball ball = new Ball(count);
        assertThat(ball.getText()).isEqualTo(count + Rule.BALL.getName());
    }

    @DisplayName("볼이 0개인 경우 빈 텍스트를 생성한다.")
    @Test
    void text() {
        Ball ball = new Ball(0);
        assertThat(ball.getText()).isEmpty();
    }
}