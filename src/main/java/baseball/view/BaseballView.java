package baseball.view;

import baseball.domain.Message;
import nextstep.utils.Console;

public class BaseballView {

    public static String view(Message message) {
        BaseballPrint.println(message.getMessage());
        String input = Console.readLine();
        return input;
    }
}
