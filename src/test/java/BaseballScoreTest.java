import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballScoreTest {
    final int LENGTH = 3;
    int[] answerNumbers;

    @BeforeEach
    void beforeEach() {
        answerNumbers = new int[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            answerNumbers[i] = i + 1;
        }
    }

    @Test
    @DisplayName("스트라이크 3 점수계산")
    void calculateScoreCaseReturn3Strikes() {
        int[] userNumbers = {1, 2, 3};
        BaseballScore score = BaseballScore.calculateScore(userNumbers, answerNumbers);
        
        assertThat(score.getStrikeCount()).isEqualTo(3);
        assertThat(score.getBallCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("볼 3 점수계산")
    void calculateScoreCaseReturn3Balls(){
        int[] userNumbers = {3, 1, 2};
        BaseballScore score = BaseballScore.calculateScore(userNumbers, answerNumbers);

        assertThat(score.getStrikeCount()).isEqualTo(0);
        assertThat(score.getBallCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("낫싱 점수계산")
    void calculateScoreCaseReturnNothing(){
        int[] userNumbers = {7, 8, 9};
        BaseballScore score = BaseballScore.calculateScore(userNumbers, answerNumbers);

        assertThat(score.getStrikeCount()).isEqualTo(0);
        assertThat(score.getBallCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("스트라이크 1, 볼 2 점수계산")
    void calculateScoreCaseReturn1Strike2Balls(){
        int[] userNumbers = {3, 2, 1};
        BaseballScore score = BaseballScore.calculateScore(userNumbers, answerNumbers);

        assertThat(score.getStrikeCount()).isEqualTo(1);
        assertThat(score.getBallCount()).isEqualTo(2);
    }
}
