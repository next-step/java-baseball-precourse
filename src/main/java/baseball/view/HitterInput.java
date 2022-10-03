package baseball.view;

import baseball.messages.ConstMessage;
import camp.nextstep.edu.missionutils.Console;

public class HitterInput {
    public String inputValue() {
        System.out.print(ConstMessage.HITTER_INPUT_MSG);
        return Console.readLine();
    }
}
