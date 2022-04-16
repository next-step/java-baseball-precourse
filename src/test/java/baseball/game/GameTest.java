package baseball.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    @DisplayName("checkAnswer() 다른 자리의 숫자를 넘기면, 볼")
    void checkAnswer_WithComputersDigitsDescending_PassDigitNotInSamePosition_Ball() {
        NumberToIndex opponent = new GameState(Arrays.asList(3, 2, 1)).getComputersDigits();

        Judgment result = Game.checkAnswer(opponent,1, 0);

        assertThat(result).isEqualTo(Judgment.BALL);
    }

    @Test
    @DisplayName("checkAnswer() 같은 자리의 숫자를 넘기면, 스트라이크")
    void checkAnswer_WithComputersDigitsDescending_PassDigitInSamePosition_Strike() {
        NumberToIndex opponent = new GameState(Arrays.asList(3, 2, 1)).getComputersDigits();

        Judgment result = Game.checkAnswer(opponent,3, 0);
        
        assertThat(result).isEqualTo(Judgment.STRIKE);
    }

    @Test
    @DisplayName("judge() 다른 자리의 숫자 3개일 때, 3볼 0스트라이크")
    void judge_WithComputersDigitsDescending_Pass3DigitsNotInSamePosition_3Balls() {
        NumberToIndex opponent = new GameState(Arrays.asList(3, 2, 1)).getComputersDigits();
        NumberToIndex answer = GameUtil.parseDigitsFrom("213");

        RoundScore result = Game.judge(opponent, answer);

        assertThat(result.getNumBalls()).isEqualTo(3);
        assertThat(result.getNumStrikes()).isEqualTo(0);
    }

    @Test
    @DisplayName("judge() 다른 자리의 숫자 2개와 같은 자리의 숫자 1개일 때, 2볼 1스트라이크")
    void judge_WithComputersDigitsDescending_Pass2DigitsNotInSamePosition1DigitInSamePosition_2Balls1Strike() {
        NumberToIndex opponent = new GameState(Arrays.asList(3, 2, 1)).getComputersDigits();
        NumberToIndex answer = GameUtil.parseDigitsFrom("231");

        RoundScore result = Game.judge(opponent, answer);

        assertThat(result.getNumBalls()).isEqualTo(2);
        assertThat(result.getNumStrikes()).isEqualTo(1);
    }

    @Test
    @DisplayName("judge() 같은 자리의 숫자 3개일 때, 0볼 3스트라이크")
    void judge_WithComputersDigitsDescending_Pass3DigitsInSamePosition_3Strikes() {
        NumberToIndex opponent = new GameState(Arrays.asList(3, 2, 1)).getComputersDigits();
        NumberToIndex answer = GameUtil.parseDigitsFrom("321");

        RoundScore result = Game.judge(opponent, answer);

        assertThat(result.getNumBalls()).isEqualTo(0);
        assertThat(result.getNumStrikes()).isEqualTo(3);
    }

    @Test
    @DisplayName("judge() 같은 자리의 숫자 3개일 때, 0볼 0스트라이크")
    void judge_Pass3DigitsNotContained_0Ball0Strike() {
        NumberToIndex opponent = new GameState(Arrays.asList(3, 2, 1)).getComputersDigits();
        NumberToIndex answer = GameUtil.parseDigitsFrom("456");

        RoundScore result = Game.judge(opponent, answer);

        assertThat(result.getNumBalls()).isEqualTo(0);
        assertThat(result.getNumStrikes()).isEqualTo(0);
    }
}
