package baseball;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallAnswerTest {

    @Test
    public void create_different_number_test() {
        BaseBallAnswer baseBallAnswer = new BaseBallAnswer();
        List<Integer> answer = baseBallAnswer.getAnswer();
        Set<Integer> answerSet = new HashSet<>(answer);
        assertThat(answer.size()).isEqualTo(answerSet.size());
    }
}
