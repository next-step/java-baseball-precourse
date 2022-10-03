package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.constant.GameEnvironment;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    @DisplayName("게임이 시작된 이후 게임 상태 조회")
    void isRunning() {
        // then
        assertThat(game.isRunning()).isTrue();
        assertThat(game.isOver()).isFalse();
    }

    @Test
    @DisplayName("게임이 종료된 이후 게임 상태 조회")
    void isOver() {
        // when
        game.over();

        assertThat(game.isRunning()).isFalse();
        assertThat(game.isOver()).isTrue();
    }

    @Test
    @DisplayName("사용자 시도가 3스트라이크인 경우 게임 종료")
    void gameOver() {
        // given
        List<Integer> gameNumbers = new LinkedList<>(Arrays.asList(1, 2, 3));
        List<Integer> userNumbers = new LinkedList<>(Arrays.asList(1, 2, 3));
        GameCounter gameCounter = new GameCounter();

        // when
        gameCounter.calculate(userNumbers, gameNumbers);
        if (gameCounter.getStrike() == GameEnvironment.NUMBER_SIZE) {
            game.over();
        }

        // then
        assertThat(game.isOver()).isTrue();
        assertThat(game.isRunning()).isFalse();
    }
}