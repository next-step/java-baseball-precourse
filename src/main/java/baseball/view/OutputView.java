package baseball.view;

import baseball.code.InGameText;

public class OutputView {
    public static void ballCount(String ballCount) {
        System.out.println(ballCount);
    }

    public static void endGame() {
        System.out.println(InGameText.ENDGAME.getInGameText());
    }
}
