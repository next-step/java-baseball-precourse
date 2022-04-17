package baseball.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    @DisplayName("게임 시작 테스트")
    void gameStartTest() {
        Game game = new BaseBallGame();
        game.start();
        // 콘솔 테스트는 어떻게 하는걸까..?
    }
}
