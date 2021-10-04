package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AnswerResultTest {

    @Test
    public void add_strike_test() {
        AnswerResult answerResult = new AnswerResult(1, 0);
        assertThat(answerResult.getStrikeCount()).isEqualTo(1);
    }

    @Test
    public void add_ball_test() {
        AnswerResult answerResult = new AnswerResult(0, 1);
        assertThat(answerResult.getBallCount()).isEqualTo(1);
    }

    @Test
    public void three_strike_test() {
        AnswerResult answerResult = new AnswerResult(3, 0);

        assertThat(answerResult.isCorrectAnswer()).isEqualTo(true);
    }
}
