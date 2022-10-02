package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class RefereeTest {
    private final Referee referee = new Referee();

    @Test
    void one_strike_test() {
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));
        Balls userBalls = new Balls(Arrays.asList(1, 7, 8));
        JudgementResult result = referee.judgement(computerBalls, userBalls);
        assertThat(result.toString()).isEqualTo("1스트라이크");
    }

    @Test
    void two_ball_test() {
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));
        Balls userBalls = new Balls(Arrays.asList(3, 1, 5));
        JudgementResult result = referee.judgement(computerBalls, userBalls);
        assertThat(result.toString()).isEqualTo("2볼 ");
    }

    @Test
    void one_strike_two_ball_test() {
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));
        Balls userBalls = new Balls(Arrays.asList(1, 3, 2));
        JudgementResult result = referee.judgement(computerBalls, userBalls);
        assertThat(result.toString()).isEqualTo("2볼 1스트라이크");
    }

    @Test
    void three_strike_test() {
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));
        Balls userBalls = new Balls(Arrays.asList(1, 2, 3));
        JudgementResult result = referee.judgement(computerBalls, userBalls);
        assertThat(result.toString()).isEqualTo("3스트라이크");
        assertThat(result.isPlayerWin()).isTrue();
    }

    @Test
    void nothing_test() {
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));
        Balls userBalls = new Balls(Arrays.asList(5, 6, 7));
        JudgementResult result = referee.judgement(computerBalls, userBalls);
        assertThat(result.toString()).isEqualTo("낫싱");
    }
}
