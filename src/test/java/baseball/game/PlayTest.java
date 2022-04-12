package baseball.game;

import baseball.model.Board;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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

    @Test
    void writeScoreTest_strike() {
        Board board = new Board();
        Play play = new Play();
        board.setGoal(new int[]{1, 2, 3});

        play.writeScore(board, "123");

        assertThat(board.getScore()[1]).isEqualTo(3);
        assertThat(board.getScore()[0]).isEqualTo(0);

    }

    @Test
    void writeScoreTest_ball() {
        Board board = new Board();
        Play play = new Play();
        board.setGoal(new int[]{1, 2, 3});

        play.writeScore(board, "132");

        assertThat(board.getScore()[1]).isEqualTo(1);
        assertThat(board.getScore()[0]).isEqualTo(2);

    }

    @Test
    void writeScoreTest_notThing() {
        Board board = new Board();
        Play play = new Play();
        board.setGoal(new int[]{1, 2, 3});

        play.writeScore(board, "456");

        assertThat(board.getScore()[1]).isEqualTo(0);
        assertThat(board.getScore()[0]).isEqualTo(0);

    }

    @Test
    void checkNumTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int[] goal = new int[]{1, 2, 3};
        Play play = new Play();
        Method method = play.getClass().getDeclaredMethod("checkNum", int[].class, int.class, int.class);
        method.setAccessible(true);

        int retStrike = (int) method.invoke(play, goal, 1,0);
        assertThat(retStrike).isEqualTo(1);

        int retBall = (int) method.invoke(play, goal, 1,1);
        assertThat(retBall).isEqualTo(2);

        int retNot = (int) method.invoke(play, goal, 4,0);
        assertThat(retNot).isEqualTo(3);

    }
}
