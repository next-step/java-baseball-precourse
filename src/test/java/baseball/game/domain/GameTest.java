package baseball.game.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("게임")
class GameTest {

    @DisplayName("게임 시작")
    @Test
    void startGame() {
        Game game = new Game();
        game.start();
        assertThat(game.getStatus()).isEqualTo(GameStatus.PLAYING);
    }

    @DisplayName("게임 종료")
    @Test
    void endGame() {
        Game game = new Game();
        game.end();
        assertThat(game.getStatus()).isEqualTo(GameStatus.STOP);
    }

}
