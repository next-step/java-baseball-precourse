package baseball.view;

import baseball.common.Message;
import baseball.domain.BallCount;

public class OutputProvider {
    public static void printWrongNumber() {
        System.out.println(Message.ERROR_WRONG_INPUT);
    }

    public static void printWrongSize() {
        System.out.println(Message.ERROR_WRONG_SIZE);
    }

    public static void printDuplication() {
        System.out.println(Message.ERROR_INPUT_DUPLICATION);
    }

    public static void printInputNumbers() {
        System.out.print(Message.REQUEST_INPUT_NUMBERS);
    }

    public static void printFinishGame() {
        System.out.println(Message.FINISH_GAME);
    }

    public static void printBallCount(BallCount ballCount) {
        System.out.println(ballCount.toString());
    }

    public static void printRetryOption() {
        System.out.println(Message.RETRY_OPTION);
    }
}
