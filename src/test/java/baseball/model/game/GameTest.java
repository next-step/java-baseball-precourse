package baseball.model.game;

import baseball.model.computer.Computer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class GameTest {

    @Test
    void compareBall_3스트라이크() {
        Game game = new Game();
        Computer computer = new Computer();
        String computerBall = computer.getBall();

        String result = game.compareBall(computerBall, computerBall);
        assertThat(result).contains("3스트라이크");
    }

    @Test
    void compareBall_1스트라이크_1볼() {
        Game game = new Game();

        String result = game.compareBall("123", "713");
        assertThat(result).contains("1볼 1스트라이크");
    }

    @Test
    void compareBall_1볼() {
        Game game = new Game();

        String result = game.compareBall("145", "713");
        assertThat(result).contains("1볼");
    }

    @Test
    void compareBall_2볼() {
        Game game = new Game();

        String result = game.compareBall("671", "713");
        assertThat(result).contains("2볼");
    }
}
