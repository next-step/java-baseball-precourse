package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallNumberTest {

    @Test
    public void collect_answer_result_test() {
        BaseBallNumber baseBallNumber = new BaseBallNumber(123);
        AnswerResult answerResult = new AnswerResult(3, 0);

        assertThat(baseBallNumber.makeAnswerResult(123)).isEqualTo(answerResult);
    }
}
