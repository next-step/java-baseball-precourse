package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AnswerResultTest {

    @Test
    public void three_strike_test() {
        AnswerResult answerResult = new AnswerResult();
        answerResult.addStrikeCount();
        answerResult.addStrikeCount();
        answerResult.addStrikeCount();

        assertThat(answerResult.isCorrectAnswer()).isEqualTo(true);
    }
}
