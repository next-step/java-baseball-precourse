package baseball;

import baseball.common.GameMessage;

public class GameConsole {
    public static void askContinue() {
        System.out.println(GameMessage.ASK_CONTINUE.getMessage());
    }

    public static void requestProposalNumber() {
        System.out.print(GameMessage.REQ_PROPOSAL_NUMBER.getMessage());
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void resultStrike(int n) {
        System.out.print(GameMessage.STRIKE_RESULT.getMessageWithNumber(n));
    }

    public static void resultBall(int n, boolean isStrikeZero) {
        String blank = "";
        if (!isStrikeZero) {
            blank = " ";
        }
        System.out.print(blank.concat(GameMessage.BALL_RESULT.getMessageWithNumber(n)));
    }

    public static void resultNothing() {
        System.out.print(GameMessage.NOTHING_RESULT.getMessage());
    }

    public static void lineBreak() {
        System.out.print(GameMessage.LINE_BREAK.getMessage());
    }

    public static void gameEnd() {
        System.out.println(GameMessage.GAME_END.getMessage());
    }
}
