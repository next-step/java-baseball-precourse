package baseball.view;

import baseball.domain.GameResult;
import baseball.domain.message.OutputMessage;

public class OutputView {
    public static void printResult(GameResult gameResult) {
        if (!gameResult.isWinning() && !gameResult.isNothing()) {
            printBallAndStrikeMessage(gameResult);
        }

        if (gameResult.isWinning()) {
            printWinningMessage();
        }
        if (gameResult.isNothing()) {
            printNothingMessage();
        }
    }

    private static void printBallAndStrikeMessage(GameResult gameResult) {
        StringBuilder result = new StringBuilder();
        int strike = gameResult.getStrike();
        int ball = gameResult.getBall();
        if (ball > 0) {
            addBallString(result, ball);
        }
        if (strike > 0) {
            addStrikeString(result, strike);
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

    private static void printWinningMessage() {
        System.out.println("3" + OutputMessage.STRIKE);
        System.out.println(OutputMessage.WINNING);
    }

    private static void printNothingMessage() {
        System.out.println(OutputMessage.NOTHING);
    }
}
