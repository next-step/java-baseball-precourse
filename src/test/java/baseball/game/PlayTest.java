package baseball.game;

import baseball.model.Board;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayTest {

    @Test
    void initGoalTest() {
        Board board = new Board();

        Play play = new Play();

        play.initGoal(board);

        assertThat(board.getGoal()[0]).isGreaterThan(0);
    }
}
