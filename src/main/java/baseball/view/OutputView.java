package baseball.view;

import baseball.code.InGameText;
import baseball.exception.BaseballException;

public class OutputView {
    public static void ballCount(String ballCount) {
        System.out.println(ballCount);
    }

    public static void endGame() {
        System.out.println(InGameText.ENDGAME.getInGameText());
    }

    public static void error(BaseballException baseballException) {
        System.out.println(baseballException.getMessage());
    }
}
