package baseball.view;

import baseball.domain.Score;
import nextstep.utils.Console;

import java.io.PrintStream;
import java.util.NoSuchElementException;

public class GameView {

    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞췄습니다! 게임 끝";
    private static final String GAME_RESUME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INVALID_RESUME_VALUE_MESSAGE = "[ERROR] 1과 2중 하나의 숫자를 선택해주세요.";

    private static final PrintStream out = System.out;

    public String showInputMessage() {
        String input = getInput();
        out.println(INPUT_NUMBER_MESSAGE + input);
        return input;
    }

    public void showScoreMessage(Score score) {
        out.println(score.getText());
    }

    public void showEndMessage() {
        out.println(GAME_END_MESSAGE);
    }

    public void showResumeMessage() {
        System.out.println(GAME_RESUME_MESSAGE);
    }

    public void showResumeError() {
        System.out.println(INVALID_RESUME_VALUE_MESSAGE);
    }

    public String getInput() {
        return readLine();
    }

    public String getResume() {
        return readLine();
    }

    private String readLine() {
        return Console.readLine();
    }
}
