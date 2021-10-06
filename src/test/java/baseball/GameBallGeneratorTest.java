package baseball;

import baseball.domain.GameBallGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameBallGeneratorTest {
    @Test
    @DisplayName("게임볼숫자생성테스트")
    void createGameBallNums() {
        List<Integer> gameBallNums = GameBallGenerator.generateBaseballNums();
        System.out.println("gameBallNums = " + gameBallNums);
        assertThat(gameBallNums.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("사용자입력숫자게임볼생성테스트")
    void createUserInputGameBallNums() {
        List<Integer> gameBallNums = GameBallGenerator.generateBaseballNums("123");
        //System.out.println("gameBallNums = " + gameBallNums);
        assertThat(gameBallNums.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("게임볼생성숫자중복테스트")
    void isDuplicateGameBallNums() {
        boolean isDuplicate = false;
        List<Integer> gameBallDuplicateNums = Arrays.asList(1,1,2);

        for (int i = 0; i < gameBallDuplicateNums.size(); i++) {
            isDuplicate = verifyDuplicate(gameBallDuplicateNums,gameBallDuplicateNums.get(i));
            if (isDuplicate) break;
        }
        assertThat(isDuplicate).isTrue();

        List<Integer> gameBallNums = GameBallGenerator.generateBaseballNums();

        for (int i = 0; i < gameBallNums.size(); i++) {
            isDuplicate = verifyDuplicate(gameBallNums,gameBallNums.get(i));
            if (isDuplicate) break;
        }
        assertThat(isDuplicate).isFalse();
    }

    boolean verifyDuplicate(List<Integer> gameBallNums, int ballNum) {
        if (Collections.frequency(gameBallNums, ballNum) > 1) {
            return true;
        }
        return false;
    }
}
