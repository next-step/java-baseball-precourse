package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    public Game game = new Game();

    @Test
    @DisplayName(value = "게임 시작시, 중복되지 않은 3개의 숫자가 생성되는지 체크")
    public void 게임시작시_중복되지않은3개의숫자생성() {
        game.start();
        assertThat(game.computerBalls.size()).isEqualTo(3);
    }
}