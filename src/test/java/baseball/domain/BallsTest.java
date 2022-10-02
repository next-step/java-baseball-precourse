package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class BallsTest {
    private final Balls balls = new Balls(Arrays.asList(1, 3, 7));

    @Test
    void 특정_위치에_있는_공을_가져올수_있다() {
        int position = 0;
        assertThat(balls.getBall(position)).isEqualTo(new Ball(1));
    }

    @Test
    void 포함하지_않은_Ball_객체라도_BallNumber_가_같을경우_True() {
        Ball ball = new Ball(3);
        assertThat(balls.hasBall(ball)).isTrue();
    }
}
