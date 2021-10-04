package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class BallTest {

    @Test
    @DisplayName("Ball 객체를 생성하여 객체를 비교한다")
    void create() {
        Ball ball = new Ball(0, 1);
        assertThat(ball).isEqualTo(new Ball(0, 1));
    }
}