package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class BallsTest {

    private Balls balls = new Balls(Arrays.asList(1, 2, 3));

    @Test
    @DisplayName("123, 134 비교 시 1스트라이크 1볼")
    void strike1_ball1() {
        PlayResult result = balls.play(new Balls(Arrays.asList(1, 3, 4)));

        assertAll(
                () -> assertThat(result.getStrike()).isEqualTo(1),
                () -> assertThat(result.getBall()).isEqualTo(1),
                () -> assertThat(result.isEndGame()).isFalse()
        );
    }

    @Test
    @DisplayName("123, 312 비교 시 3볼")
    void ball3() {
        PlayResult result = balls.play(new Balls(Arrays.asList(3, 1, 2)));

        assertAll(
                () -> assertThat(result.getStrike()).isEqualTo(0),
                () -> assertThat(result.getBall()).isEqualTo(3),
                () -> assertThat(result.isEndGame()).isFalse()
        );
    }

    @Test
    @DisplayName("123, 123 비교 시 3스트라이크")
    void strike3() {
        PlayResult result = balls.play(new Balls(Arrays.asList(1, 2, 3)));

        assertAll(
                () -> assertThat(result.getStrike()).isEqualTo(3),
                () -> assertThat(result.getBall()).isEqualTo(0),
                () -> assertThat(result.isEndGame()).isTrue()

        );
    }

}
