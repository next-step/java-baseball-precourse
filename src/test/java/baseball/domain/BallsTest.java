package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    @Test
    @DisplayName(value = "Balls 생성시 3개의 랜덤 숫자 생성여부")
    public void 생성시_3랜덤숫자생성여부() {
        Balls balls = new Balls();
        assertThat(balls.computerBalls.size()).isEqualTo(3);
    }

    //== 스트라이크, 볼, 낫싱 여부 ==//
    @Test
    @DisplayName(value = "낫싱 반환 여부 체크")
    public void 낫싱() {
        Balls balls = new Balls();
        balls.computerBalls = Arrays.asList(1, 2, 3);
        assertThat(balls.play(Arrays.asList(5, 6, 7)).isNothing()).isEqualTo(true);
    }

    @Test
    public void 스트라이크1() {
        Balls balls = new Balls();
        balls.computerBalls = Arrays.asList(1, 2, 3);
        assertThat(balls.play(Arrays.asList(1, 6, 7)).getStrike()).isEqualTo(1);
    }

    @Test
    public void 스트라이크1_볼1() {
        Balls balls = new Balls();
        balls.computerBalls = Arrays.asList(1, 2, 3);
        assertThat(balls.play(Arrays.asList(1, 6, 2)).getStrike()).isEqualTo(1);
        assertThat(balls.play(Arrays.asList(1, 6, 2)).getBall()).isEqualTo(1);
    }

    @Test
    public void 스트라이크1_볼2() {
        Balls balls = new Balls();
        balls.computerBalls = Arrays.asList(1, 2, 3);
        assertThat(balls.play(Arrays.asList(1, 3, 2)).getStrike()).isEqualTo(1);
        assertThat(balls.play(Arrays.asList(1, 3, 2)).getBall()).isEqualTo(2);
    }

    @Test
    public void 스트라이크3() {
        Balls balls = new Balls();
        balls.computerBalls = Arrays.asList(1, 2, 3);
        assertThat(balls.play(Arrays.asList(1, 2, 3)).getStrike()).isEqualTo(3);
    }

    @Test
    public void 볼3() {
        Balls balls = new Balls();
        balls.computerBalls = Arrays.asList(1, 2, 3);
        assertThat(balls.play(Arrays.asList(3, 1, 2)).getBall()).isEqualTo(3);
    }
}