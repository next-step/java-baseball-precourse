package baseball.view;

import baseball.messages.ConstMessage;
import camp.nextstep.edu.missionutils.Console;

public class ProgressInput {
    public String gameProgressInputValue(int limitNumber, String restartString) {
        System.out.printf((ConstMessage.STRIKE_OUT_MSG) + "%n", limitNumber);
        System.out.printf((ConstMessage.PROGRESS_INPUT_MSG) + "%n", restartString);
        return Console.readLine();
    }
}
