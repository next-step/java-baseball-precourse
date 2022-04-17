package baseball.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    @DisplayName("게임 시작 테스트")
    void gameStartTest() {
        Game game = new BaseBallGame();
        game.start();
    }
}
