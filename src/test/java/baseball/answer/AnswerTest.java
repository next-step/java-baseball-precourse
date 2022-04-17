package baseball.answer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static baseball.answer.AnswerErrorEnum.*;
import static org.assertj.core.api.Assertions.*;

class AnswerTest {

    @Test
    @DisplayName("Answer 생성 테스트")
    void createAnswerTest() {
        int strike = 1;
        int ball = 2;
        Answer answer = new Answer();
        addNumberOfStrikes(answer, strike);
        addNumberOfBalls(answer, ball);
        assertThat(answer.getBall()).isEqualTo(ball);
        assertThat(answer.getStrike()).isEqualTo(strike);
    }


    @Test
    @DisplayName("Answer 생성 합계 초과 테스트")
    void sumOverThreeTest() {
        int num = 4;
        assertThatThrownBy(()-> {
            Answer answer = new Answer();
            addNumberOfStrikes(answer, num);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(SUM_OVER_THREE.text());
        assertThatThrownBy(()-> {
            Answer answer = new Answer();
            addNumberOfBalls(answer,num);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(SUM_OVER_THREE.text());
    }

    private void addNumberOfBalls(Answer answer, int num) {
        for (int i = 0; i < num; i++) {
            answer.addBall();
        }
    }
    private void addNumberOfStrikes(Answer answer, int num) {
        for (int i = 0; i < num; i++) {
            answer.addStrike();
        }
    }
}