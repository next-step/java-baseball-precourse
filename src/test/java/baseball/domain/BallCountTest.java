package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BallCountTest {
    private final List<Ball> resultBall = new ArrayList<>();

    @BeforeEach
    void init() {
        resultBall.add(new Ball(1, 7));
        resultBall.add(new Ball(2, 1));
        resultBall.add(new Ball(3, 3));
    }

    @Test
    @DisplayName(("볼카운트_1볼_1스트라이크"))
    void 볼카운트_1볼_1스트라이크() {
        List<Integer> inputNumbers = Arrays.asList(1, 2, 3);
        String expectedResult = "1볼 1스트라이크";
        BallCount ballCount = new BallCount();
        for (Ball ball : resultBall) {
            ballCount.judgeNumbers(inputNumbers, ball);
        }
        assertThat(ballCount.toString()).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName(("볼카운트_1볼"))
    void 볼카운트_1볼() {
        List<Integer> inputNumbers = Arrays.asList(1, 4, 5);
        String expectedResult = "1볼";
        BallCount ballCount = new BallCount();
        for (Ball ball : resultBall) {
            ballCount.judgeNumbers(inputNumbers, ball);
        }
        assertThat(ballCount.toString()).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName(("볼카운트_2볼"))
    void 볼카운트_2볼() {
        List<Integer> inputNumbers = Arrays.asList(6, 7, 1);
        String expectedResult = "2볼";
        BallCount ballCount = new BallCount();
        for (Ball ball : resultBall) {
            ballCount.judgeNumbers(inputNumbers, ball);
        }
        assertThat(ballCount.toString()).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName(("볼카운트_1스트라이크"))
    void 볼카운트_1스트라이크() {
        List<Integer> inputNumbers = Arrays.asList(2, 1, 6);
        String expectedResult = "1스트라이크";
        BallCount ballCount = new BallCount();
        for (Ball ball : resultBall) {
            ballCount.judgeNumbers(inputNumbers, ball);
        }
        assertThat(ballCount.toString()).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName(("볼카운트_3스트라이크"))
    void 볼카운트_3스트라이크() {
        List<Integer> inputNumbers = Arrays.asList(7, 1, 3);
        String expectedResult = "3스트라이크";
        BallCount ballCount = new BallCount();
        for (Ball ball : resultBall) {
            ballCount.judgeNumbers(inputNumbers, ball);
        }
        assertThat(ballCount.toString()).isEqualTo(expectedResult);
    }
}
