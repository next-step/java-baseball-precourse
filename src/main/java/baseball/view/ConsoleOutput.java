package baseball.view;

import static baseball.constant.GameConfig.END_GAME_MESSAGE;

public class ConsoleOutput {

    private ConsoleOutput() {

    }

    public static void printResult(final String message) {
        System.out.println(message);
    }

    public static void printGameEndMessage() {
        System.out.println(END_GAME_MESSAGE);
    }
}
