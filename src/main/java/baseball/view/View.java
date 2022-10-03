package baseball.view;

import static baseball.type.GameMessageType.FINISH;
import static baseball.type.GameMessageType.INPUT_NUMBER;
import static baseball.type.GameMessageType.RESTART_OR_FINISH;

import baseball.domain.Hint;

public class View {

    public static void printInputNumber() {
        System.out.print(INPUT_NUMBER.getMessage());
    }

    public static void printFinish() {
        System.out.println(FINISH.getMessage());
    }

    public static void printRestartOrFinish() {
        System.out.println(RESTART_OR_FINISH.getMessage());
    }

    public static void printHint(Hint hint) {
        System.out.println(hint.toString());
    }
}
