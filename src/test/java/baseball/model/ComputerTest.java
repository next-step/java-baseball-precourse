package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.controller.Game;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class ComputerTest {
    private Computer computer;

    @BeforeEach
    void setUp() {
        computer = new Computer();
        computer.generateBalls();
    }

    @RepeatedTest(10)
    @DisplayName("서로 다른 숫자 3개 생성")
    void generate_three_different_numbers_test() {
        Set<Integer> ballSet = new HashSet<>(computer.balls());
        assertThat(ballSet).hasSize(Game.BALL_INPUT_SIZE);
    }

    @RepeatedTest(10)
    @DisplayName("1-9까지의 숫자만 생성")
    void is_digit_1_to_9_test() {
        for (Integer ball : computer.balls()) {
            assertThat(ball).isGreaterThanOrEqualTo(Game.BALL_MIN_NUMBER);
            assertThat(ball).isLessThanOrEqualTo(Game.BALL_MAX_NUMBER);
            assertThat(ball).isNotZero();
        }
    }
}