package baseball.view;

import baseball.util.Message;

public class OutputView {
    public static void printErrorInput() {
        System.out.println(Message.ERROR_INPUT.getMessage());
    }

    public static void printBall(int bCount) {
        System.out.printf(Message.BALL.getMessage(), bCount);
    }

    public static void printStrike(int sCount) {
        System.out.printf(Message.STRIKE.getMessage(), sCount);
    }

    public static void printNothing() {
        System.out.print(Message.NOTHING.getMessage());
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printFinish() {
        System.out.println(Message.FINISH.getMessage());
    }
}
