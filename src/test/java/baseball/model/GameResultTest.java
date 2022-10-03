package baseball.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameResultTest {
    private GameResult gameResult;

    @BeforeEach
    public void createGameResult() { gameResult = new GameResult(); }

    @DisplayName("gameResult결과 출력 확인")
    @Test
    public void matchAlrightGameScorePrint() {
        gameResult.updateResult("스트라이크");
        gameResult.updateResult("볼");
        gameResult.updateResult("볼");

        assertEquals("2볼 1스트라이크", gameResult.printGameResult());
    }
}
