package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BallsTest {

    private Balls balls;

    @BeforeEach
    void setUp() {
        balls = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    void 원_스트라이크_원_볼() {
        PlayResult result = balls.compare("134");
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    void 쓰리_스트라이크() {
        PlayResult result = balls.compare("123");
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isZero();
    }

    @Test
    void 낫싱() {
        PlayResult result = balls.compare("456");
        assertThat(result.getStrike()).isZero();
        assertThat(result.getBall()).isZero();
    }

    @Test
    void 서로_다른_세_자리_수_생성() {
        balls.makeNumbers();
        List<Ball> ballList = balls.getBallList();
        assertThat(ballList.get(0)).isNotEqualTo(ballList.get(1))
                .isNotEqualTo(ballList.get(2));
        assertThat(ballList.get(1)).isNotEqualTo(ballList.get(2));
    }
}
