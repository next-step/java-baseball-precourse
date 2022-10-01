package baseball.ui;

import baseball.domain.ConsoleMessage;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleView {

    public static String input(ConsoleMessage consoleMessage) {
        System.out.println(consoleMessage.getMessage());
        return Console.readLine();
    }

    public static void output(ConsoleMessage consoleMessage) {
        System.out.println(consoleMessage.getMessage());
    }

    public static void output(String message) {
        System.out.println(message);
    }
}
