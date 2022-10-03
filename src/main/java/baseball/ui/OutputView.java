package baseball.ui;

import baseball.code.InGameText;
import baseball.exception.GameException;

public class OutputView {
    public static void ballCount(String ballCount) {
        System.out.println(ballCount);
    }

    public static void endGame() {
        System.out.println(InGameText.ENDGAME.getInGameText());
    }

    public static void error(GameException baseballException) {
        System.out.println(baseballException.getMessage());
    }
}
