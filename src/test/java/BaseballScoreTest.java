import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseballScoreTest {

    @Test
    @DisplayName("게임 우승 판정 테스트")
    void testGameWin() {
        BaseballScore baseballScore = new BaseballScore();

        TurnResult result = baseballScore.calculateResult(new int[]{1, 2, 3}, new int[]{1, 2, 3});
        assertEquals(3, result.strike);
    }

    @Test
    @DisplayName("스트라이크 테스트")
    void testStrike() {
        BaseballScore baseballScore = new BaseballScore();

        TurnResult result = baseballScore.calculateResult(new int[]{1, 2, 3}, new int[]{1, 2, 9});
        assertEquals(2, result.strike);
        assertEquals(0, result.ball);
    }

    @Test
    @DisplayName("볼 테스트")
    void testBall() {
        BaseballScore baseballScore = new BaseballScore();

        TurnResult result = baseballScore.calculateResult(new int[]{1, 2, 3}, new int[]{2, 1, 9});
        assertEquals(0, result.strike);
        assertEquals(2, result.ball);
    }
}
