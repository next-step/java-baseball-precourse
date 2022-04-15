package baseball.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundScoreTest {
    @Test
    @DisplayName("addJudgment() 스트라이크를 3번, 볼을 2번 넘기면, 2볼과 3스트라이크가 카운트")
    void addJudgment_AddBall2TimesAndStrike3Times_Counts2BallsAnd3Strikes() {
        RoundScore score = new RoundScore();
        score.addJudgment(Judgment.BALL);
        score.addJudgment(Judgment.BALL);
        score.addJudgment(Judgment.STRIKE);
        score.addJudgment(Judgment.STRIKE);
        score.addJudgment(Judgment.STRIKE);
        assertThat(score.getNumBalls()).isEqualTo(2);
        assertThat(score.getNumStrikes()).isEqualTo(3);
    }
}
