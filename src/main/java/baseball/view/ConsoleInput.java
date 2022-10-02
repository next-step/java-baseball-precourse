package baseball.view;

import static baseball.constant.GameConfig.NUMBER_INPUT_MESSAGE;
import static baseball.constant.GameConfig.RESTART_INPUT_MESSAGE;

public class ConsoleInput {

    public static void inputMessage() {
        System.out.print(NUMBER_INPUT_MESSAGE);
    }

    public static void restartInputMessage() {
        System.out.println(RESTART_INPUT_MESSAGE);
    }
}
