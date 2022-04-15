package baseball.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    @Test
    @DisplayName("checkAnswer() 컴퓨터의 숫자가 오름차순일 때, 다른 자리의 숫자를 넘기면, 볼")
    void checkAnswer_WithComputersNumbersAscending_PassNumberNotInSamePosition_Ball() {
        GameState state = new GameState(Arrays.asList(1, 2, 3));
        Judgment result = Game.checkAnswer(state,3, 0);
        assertThat(result).isEqualTo(Judgment.BALL);
    }

    @Test
    @DisplayName("checkAnswer() 컴퓨터의 숫자가 내림차순일 때, 다른 자리의 숫자를 넘기면, 볼")
    void checkAnswer_WithComputersNumbersDescending_PassNumberNotInSamePosition_Ball() {
        GameState state = new GameState(Arrays.asList(3, 2, 1));
        Judgment result = Game.checkAnswer(state,1, 0);
        assertThat(result).isEqualTo(Judgment.BALL);
    }

    @Test
    @DisplayName("checkAnswer() 컴퓨터의 숫자가 오름차순일 때, 같은 자리의 숫자를 넘기면, 스트라이크")
    void checkAnswer_WithComputersNumbersAscending_PassNumberInSamePosition_Strike() {
        GameState state = new GameState(Arrays.asList(1, 2, 3));
        Judgment result = Game.checkAnswer(state,1, 0);
        assertThat(result).isEqualTo(Judgment.STRIKE);
    }

    @Test
    @DisplayName("checkAnswer() 컴퓨터의 숫자가 내림차순일 때, 같은 자리의 숫자를 넘기면, 스트라이크")
    void checkAnswer_WithComputersNumbersDescending_PassNumberInSamePosition_Strike() {
        GameState state = new GameState(Arrays.asList(3, 2, 1));
        Judgment result = Game.checkAnswer(state,3, 0);
        assertThat(result).isEqualTo(Judgment.STRIKE);
    }

    @Test
    @DisplayName("judge() 컴퓨터의 숫자가 오름차순일 때, 다른 자리의 숫자 3개일 때, 3볼 0스트라이크")
    void judge_WithComputersNumbersAscending_Pass3NumbersNotInSamePosition_3Balls() {
        GameState state = new GameState(Arrays.asList(1, 2, 3));
        NumberToIndex answer = new NumberToIndex("231");
        RoundScore result = Game.judge(state, answer);
        assertThat(result.getNumBalls()).isEqualTo(3);
        assertThat(result.getNumStrikes()).isEqualTo(0);
    }

    @Test
    @DisplayName("judge() 컴퓨터의 숫자가 내림차순일 때, 다른 자리의 숫자 3개일 때, 3볼 0스트라이크")
    void judge_WithComputersNumbersDescending_Pass3NumbersNotInSamePosition_3Balls() {
        GameState state = new GameState(Arrays.asList(3, 2, 1));
        NumberToIndex answer = new NumberToIndex("213");
        RoundScore result = Game.judge(state, answer);
        assertThat(result.getNumBalls()).isEqualTo(3);
        assertThat(result.getNumStrikes()).isEqualTo(0);
    }

    @Test
    @DisplayName("judge() 컴퓨터의 숫자가 오름차순일 때, 다른 자리의 숫자 2개와 같은 자리의 숫자 1개일 때, 2볼 1스트라이크")
    void judge_WithComputersNumbersAscending_Pass2NumbersNotInSamePosition1NumberInSamePosition_2Balls1Strike() {
        GameState state = new GameState(Arrays.asList(1, 2, 3));
        NumberToIndex answer = new NumberToIndex("213");
        RoundScore result = Game.judge(state, answer);
        assertThat(result.getNumBalls()).isEqualTo(2);
        assertThat(result.getNumStrikes()).isEqualTo(1);
    }

    @Test
    @DisplayName("judge() 컴퓨터의 숫자가 내림차순일 때, 다른 자리의 숫자 2개와 같은 자리의 숫자 1개일 때, 2볼 1스트라이크")
    void judge_WithComputersNumbersDescending_Pass2NumbersNotInSamePosition1NumberInSamePosition_2Balls1Strike() {
        GameState state = new GameState(Arrays.asList(3, 2, 1));
        NumberToIndex answer = new NumberToIndex("231");
        RoundScore result = Game.judge(state, answer);
        assertThat(result.getNumBalls()).isEqualTo(2);
        assertThat(result.getNumStrikes()).isEqualTo(1);
    }

    @Test
    @DisplayName("judge() 컴퓨터의 숫자가 오름차순일 때, 같은 자리의 숫자 3개일 때, 0볼 3스트라이크")
    void judge_WithComputersNumbersAscending_Pass3NumbersInSamePosition_3Strikes() {
        GameState state = new GameState(Arrays.asList(1, 2, 3));
        NumberToIndex answer = new NumberToIndex("123");
        RoundScore result = Game.judge(state, answer);
        assertThat(result.getNumBalls()).isEqualTo(0);
        assertThat(result.getNumStrikes()).isEqualTo(3);
    }

    @Test
    @DisplayName("judge() 컴퓨터의 숫자가 내림차순일 때, 같은 자리의 숫자 3개일 때, 0볼 3스트라이크")
    void judge_WithComputersNumbersDescending_Pass3NumbersInSamePosition_3Strikes() {
        GameState state = new GameState(Arrays.asList(3, 2, 1));
        NumberToIndex answer = new NumberToIndex("321");
        RoundScore result = Game.judge(state, answer);
        assertThat(result.getNumBalls()).isEqualTo(0);
        assertThat(result.getNumStrikes()).isEqualTo(3);
    }

    @Test
    @DisplayName("judge() 컴퓨터의 숫자가 내림차순일 때, 같은 자리의 숫자 3개일 때, 0볼 0스트라이크")
    void judge_Pass3NumbersNotContained_0Ball0Strike() {
        GameState state = new GameState(Arrays.asList(3, 2, 1));
        NumberToIndex answer = new NumberToIndex("456");
        RoundScore result = Game.judge(state, answer);
        assertThat(result.getNumBalls()).isEqualTo(0);
        assertThat(result.getNumStrikes()).isEqualTo(0);
    }
}
