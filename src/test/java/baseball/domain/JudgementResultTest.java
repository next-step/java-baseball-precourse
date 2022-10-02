package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class JudgementResultTest {
    @Test
    void one_strike_test() {
        JudgementResult judgementResult = new JudgementResult();
        judgementResult.add(CompareResult.STRIKE);
        assertThat(judgementResult.toString()).isEqualTo("1스트라이크");
    }

    @Test
    void one_strike_one_ball_test() {
        JudgementResult judgementResult = new JudgementResult();
        judgementResult.add(CompareResult.STRIKE);
        judgementResult.add(CompareResult.BALL);
        assertThat(judgementResult.toString()).isEqualTo("1볼 1스트라이크");
    }

    @Test
    void nothing_test() {
        JudgementResult judgementResult = new JudgementResult();
        judgementResult.add(CompareResult.NOTHING);
        assertThat(judgementResult.toString()).isEqualTo("낫싱");
    }
}
