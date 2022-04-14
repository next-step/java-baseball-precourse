package baseball.answer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnswerConfigTest {
    
    @Test
    @DisplayName("Answer Config 유효성 테스트")
    void config_range_test(){
        // Answer의 max - min 범위가 Answer의 길이보다 커야 중복되지 않게 뽑을 수 있음
        // ex) 1 <= Number <= 3 일 때, 3개를 중복하지 않고 뽑을 수 있음
        int answerRange = AnswerConfig.ANSWER_NUMBER_MAX - AnswerConfig.ANSWER_NUMBER_MIN + 1;
        assertThat(answerRange + 1).isGreaterThan(AnswerConfig.ANSWER_LENGTH);
    }
}
