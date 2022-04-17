package baseball.view;

import baseball.domain.game.GameResult;
import baseball.domain.message.OutputMessage;

public class OutputView {
    public static void printResult(GameResult gameResult) {
        if (!gameResult.isWinning() && !gameResult.isNothing()) {
            printBallAndStrikeMessage(gameResult);
        }

        if (gameResult.isWinning()) {
            printWinningMessage(gameResult);
        }
        if (gameResult.isNothing()) {
            printNothingMessage();
        }
    }

    private static void printBallAndStrikeMessage(GameResult gameResult) {
        StringBuilder result = new StringBuilder();
        if (gameResult.getBall() > 0) {
            addBallString(result, gameResult.getBall());
        }
        if (gameResult.getStrike() > 0) {
            addStrikeString(result, gameResult.getStrike());
        }
        System.out.println(result);
    }

    private static void addBallString(StringBuilder result, int ball) {
        result.append(ball);
        result.append(OutputMessage.BALL);
    }

    private static void addStrikeString(StringBuilder result, int strike) {
        if (result.length() > 0) {
            result.append(" ");
        }
        result.append(strike);
        result.append(OutputMessage.STRIKE);
    }

    private static void printWinningMessage(GameResult gameResult) {
        System.out.println(gameResult.getStrike() + OutputMessage.STRIKE);
        System.out.println(OutputMessage.WINNING);
    }

    private static void printNothingMessage() {
        System.out.println(OutputMessage.NOTHING);
    }
}
