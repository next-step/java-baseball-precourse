package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    public Game game = new Game();

    @Test
    @DisplayName(value = "게임 시작시, 중복되지 않은 3개의 숫자가 생성되는지 체크")
    public void 게임시작시_중복되지않은3개의숫자생성() {
        game.start();
        assertThat(game.computerBalls.size()).isEqualTo(3);
    }

    //== 볼 스트라이크 체크 ==//
    // 스트라이크 체크
    @Test
    public void 스트라이크1() {
        game.computerBalls = Arrays.asList(1, 2, 3);
        assertThat(game.play(Arrays.asList(1, 5, 6)).getStrike()).isEqualTo(1);
    }
    @Test
    public void 스트라이크1_숫자1개만입력() {
        game.computerBalls = Arrays.asList(1, 2, 3);
        assertThat(game.play(Arrays.asList(1)).getStrike()).isEqualTo(1);
    }
    @Test
    public void 스트라이크2() {
        game.computerBalls = Arrays.asList(1, 2, 3);
        assertThat(game.play(Arrays.asList(5, 2, 3)).getStrike()).isEqualTo(2);
    }
    // 볼 체크
    @Test
    public void 볼1() {
        game.computerBalls = Arrays.asList(1, 2, 3);
        assertThat(game.play(Arrays.asList(3, 5, 6)).getBall()).isEqualTo(1);
    }
    @Test
    public void 볼1_숫자1개만입력() {
        game.computerBalls = Arrays.asList(1, 2, 3);
        assertThat(game.play(Arrays.asList(3)).getBall()).isEqualTo(1);
    }
    @Test
    public void 볼2() {
        game.computerBalls = Arrays.asList(1, 2, 3);
        assertThat(game.play(Arrays.asList(5, 3, 2)).getBall()).isEqualTo(2);
    }
}