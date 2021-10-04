package baseball;

import baseball.common.GameMessage;
import baseball.common.GameErrorMessage;

public class GameConsole {
    public static void askContinue() {
        System.out.println(GameMessage.ASK_CONTINUE.getMessage());
    }

    public static void errorAskContinue() {
        System.out.println(GameErrorMessage.INCORRECT_VALUE.getMessage());
    }
}
