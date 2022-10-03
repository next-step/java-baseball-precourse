package baseball.ui;

import baseball.code.InGameText;
import nextstep.utils.Console;

public class InputView {
    public static String enterValue() {
        System.out.print(InGameText.ENTER_VALUE.getInGameText());
        return Console.readLine();
    }

    public static String decideRestart() {
        System.out.println(InGameText.DECIDE_RESTART.getInGameText());
        return Console.readLine();
    }
}
