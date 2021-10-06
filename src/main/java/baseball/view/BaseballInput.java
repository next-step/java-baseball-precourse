package baseball.view;

import baseball.domain.Message;
import nextstep.utils.Console;

public class BaseballInput {

    public static String input(Message message) {
        BaseballPrint.println(message.getMessage());
        return Console.readLine();
    }
}
