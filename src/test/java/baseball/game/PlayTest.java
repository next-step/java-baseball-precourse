package baseball.game;

import baseball.model.Board;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayTest {

    @Test
    void initGoalTest() {
        Board board = new Board();

        Play play = new Play();

        play.initGoal(board);

        assertThat(board.getGoal()[0]).isGreaterThan(0);
    }

    @Test
    void validInputTest() {
        Play play = new Play();

        assertThatThrownBy(() -> {
            play.validInput("1234");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("입력값은 3자리 숫자여야 합니다.");
    }
}
