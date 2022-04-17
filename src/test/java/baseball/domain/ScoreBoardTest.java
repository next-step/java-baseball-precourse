package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreBoardTest {

    @Test
    void 최종스코어_카운팅결과를_검증한다1() {
        ScoreBoard scoreBoard = new ScoreBoard();
        List<Integer> answer = Arrays.asList(1, 2, 3);
        List<Integer> userAnswer = Arrays.asList(1, 2, 3);

        scoreBoard.countScore(answer, userAnswer);

        assertThat(scoreBoard.getStrike()).isEqualTo(3);
        assertThat(scoreBoard.getBall()).isEqualTo(0);
    }

    @Test
    void 최종스코어_카운팅결과를_검증한다2() {
        ScoreBoard scoreBoard = new ScoreBoard();
        List<Integer> answer = Arrays.asList(1, 2, 3);
        List<Integer> userAnswer = Arrays.asList(1, 3, 2);

        scoreBoard.countScore(answer, userAnswer);

        assertThat(scoreBoard.getStrike()).isEqualTo(1);
        assertThat(scoreBoard.getBall()).isEqualTo(2);
    }

    @Test
    void 최종스코어_카운팅결과를_검증한다3() {
        ScoreBoard scoreBoard = new ScoreBoard();
        List<Integer> answer = Arrays.asList(1, 2, 3);
        List<Integer> userAnswer = Arrays.asList(3, 1, 2);

        scoreBoard.countScore(answer, userAnswer);

        assertThat(scoreBoard.getStrike()).isEqualTo(0);
        assertThat(scoreBoard.getBall()).isEqualTo(3);
    }
}