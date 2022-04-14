package baseball.answer;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnswerTest {

    @Test
    @DisplayName("Answer 생성 테스트 (수동 초기화)")
    void init_answer_test(){
        int[] answer = new int[AnswerConfig.ANSWER_LENGTH];

        for (int idx = 0; idx < answer.length; idx++){
            answer[idx] = AnswerConfig.ANSWER_NUMBER_MIN + idx;
        }
        assertThat(new Answer(answer)).isInstanceOf(Answer.class);

        for (int idx = 0; idx < answer.length; idx++){
            answer[idx] = AnswerConfig.ANSWER_NUMBER_MAX - idx;
        }
        assertThat(new Answer(answer)).isInstanceOf(Answer.class);
    }

    @Test
    @DisplayName("길이 실패 테스트")
    void init_answer_length_fail_test(){
        int[] tooLongArray = new int[AnswerConfig.ANSWER_LENGTH + 1];
        int[] tooShortArray = new int[AnswerConfig.ANSWER_LENGTH - 1];
        
        assertThatThrownBy(() -> Answer.validateNumberLength(tooLongArray)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Answer.validateNumberLength(tooShortArray)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("범위 실패 테스트")
    void init_answer_range_fail_test(){
        int[] tooBigNumber = new int[AnswerConfig.ANSWER_LENGTH];
        Arrays.fill(tooBigNumber, AnswerConfig.ANSWER_NUMBER_MAX);
        tooBigNumber[0] = AnswerConfig.ANSWER_NUMBER_MAX + 1;

        int[] tooSmallNumber = new int[AnswerConfig.ANSWER_LENGTH];
        Arrays.fill(tooSmallNumber, AnswerConfig.ANSWER_NUMBER_MAX);
        tooSmallNumber[0] = AnswerConfig.ANSWER_NUMBER_MIN - 1;

        assertThatThrownBy(() -> Answer.validateNumberRange(tooBigNumber)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Answer.validateNumberRange(tooSmallNumber)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복 값 실패 테스트")
    void init_answer_duplicate_fail_test(){
        int[] duplicateNumber = new int[AnswerConfig.ANSWER_LENGTH];
        Arrays.fill(duplicateNumber, AnswerConfig.ANSWER_NUMBER_MAX);

        assertThatThrownBy(() -> Answer.validateNumberDuplicate(duplicateNumber)).isInstanceOf(IllegalArgumentException.class);
    }


}
