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
}
