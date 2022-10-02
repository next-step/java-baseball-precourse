package baseball.view;

import baseball.model.GameResult;

public class BaseballOutputView {
    public static void showResult(GameResult gameResult) {
        if (gameResult.isNothing()) {
            System.out.println("낫싱");
            return;
        }
        strikeAndBallResults(gameResult);
    }

    private static void strikeAndBallResults(GameResult gameResult) {
        if (gameResult.hasBall() && gameResult.hasStrike()) {
            System.out.printf("%d볼 %d스트라이크%n", gameResult.getBall(), gameResult.getStrike());
            return;
        }
        if (gameResult.hasBall()) {
            System.out.printf("%d볼%n", gameResult.getBall());
            return;
        }
        System.out.printf("%d스트라이크%n", gameResult.getStrike());
    }

    public static void gameEnd() {
        System.out.println("게임 종료");
    }
}
