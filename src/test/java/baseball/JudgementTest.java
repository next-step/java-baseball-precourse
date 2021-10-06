package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JudgementTest {

    @DisplayName("computer와 player 숫자가 같은 값일 시 승리 여부)")
    @Test
    void checkVictory() {
        List<Integer> computerNum = Arrays.asList(1,2,3);
        List<Integer> playerNum = Arrays.asList(1,2,3);

        Judgement judgement = new Judgement(computerNum, playerNum);

        assertThat(judgement.judge()).isTrue();
    }

    @DisplayName("computer와 player 숫자가 다른 값일 시 승리 여부)")
    @Test
    void checkNoVictory() {
        List<Integer> computerNum = Arrays.asList(4,5,3);
        List<Integer> playerNum = Arrays.asList(1,2,3);

        Judgement judgement = new Judgement(computerNum, playerNum);

        assertThat(judgement.judge()).isFalse();
    }

    @DisplayName("스트라이크와 볼 출력 테스트 (1스트라이크 1볼)")
    @Test
    void printJudgeResultTest() {
        List<Integer> computerNum = Arrays.asList(4,5,3);
        List<Integer> playerNum = Arrays.asList(4,3,2);

        Judgement judgement = new Judgement(computerNum, playerNum);

        assertThat(judgement.printJudgeResult()).isEqualTo("1스트라이크 1볼");

    }

}
