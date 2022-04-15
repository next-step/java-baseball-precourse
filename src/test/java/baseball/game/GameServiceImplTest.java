package baseball.game;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.answer.Answer;
import baseball.answer.AnswerConfig;

public class GameServiceImplTest {
    GameService gameService = new GameServiceImpl();

    Answer answer1;
    Answer answer2;

    @BeforeEach
    void answerInit(){
        int[] numbers = new int[AnswerConfig.ANSWER_LENGTH];
        for (int idx = 0; idx < numbers.length; idx++){
            numbers[idx] = AnswerConfig.ANSWER_NUMBER_MIN + idx;
        }
        int[] numbersClone = numbers.clone();

        answer1 = new Answer(numbers);
        answer2 = new Answer(numbersClone);
    }

    @Test
    @DisplayName("정답 비교 스트라이크 테스트")
    void compareAnswer_strike_test(){
        GameRoundResult result = gameService.compareAnswer(answer1, answer2);

        assertThat(result.getStrike()).isEqualTo(AnswerConfig.ANSWER_LENGTH);
        assertThat(result.getBall()).isZero();
    }

    @Test
    @DisplayName("정답 비교 볼 테스트")
    void compareAnswer_ball_test(){
        
        int[] numbers = answer2.getNumbers();
        int firstNumber = numbers[0];
        numbers[0] = numbers[numbers.length - 1];
        numbers[numbers.length - 1] = firstNumber;

        GameRoundResult result = gameService.compareAnswer(answer1, answer2);

        assertThat(result.getStrike()).isEqualTo(AnswerConfig.ANSWER_LENGTH - 2);
        assertThat(result.getBall()).isEqualTo(2);
    }
    
}
