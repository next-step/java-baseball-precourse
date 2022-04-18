package baseball.view;

import baseball.common.message.SystemMessage;
import camp.nextstep.edu.missionutils.Console;

public class InquireReader {

    public static String inquire() {
        System.out.printf(SystemMessage.NUMBER_REQUEST_MESSAGE);
        return Console.readLine();
    }

    public static String inquireReGame() {
        System.out.printf(SystemMessage.GAME_RESTART_MESSAGE);
        return Console.readLine();
    }
}
