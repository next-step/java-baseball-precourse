package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    @Test
    @DisplayName(value = "3 스트라이크")
    public void 스트라이크3() {
        Balls balls = new Balls(Arrays.asList(1, 2, 3));

        assertThat(balls.play(Arrays.asList(1, 2, 3))).isEqualTo(3);
    }

    @Test
    @DisplayName(value = "첫번째 두번째 수가 스트라이크")
    public void 스트라이크12() {
        Balls balls = new Balls(Arrays.asList(1, 2, 3));

        assertThat(balls.play(Arrays.asList(1, 2, 6))).isEqualTo(2);
    }

    @Test
    @DisplayName(value = "첫번째 두번째 수가 스트라이크")
    public void 스트라이크23() {
        Balls balls = new Balls(Arrays.asList(1, 2, 3));

        assertThat(balls.play(Arrays.asList(6, 2, 3))).isEqualTo(2);
    }

    @Test
    @DisplayName(value = "첫번째 두번째 수가 스트라이크")
    public void 스트라이크0() {
        Balls balls = new Balls(Arrays.asList(1, 2, 3));

        assertThat(balls.play(Arrays.asList(3, 1, 2))).isEqualTo(0);
    }
}