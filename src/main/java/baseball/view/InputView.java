package baseball.view;

import baseball.util.Message;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String getUserNumbers() {
        System.out.print(Message.INPUT.getMessage());
        return Console.readLine();
    }

    public static String getUserChoice() {
        System.out.println(Message.CHOICE.getMessage());
        return Console.readLine();
    }
}
