package baseball;

import baseball.enums.RestartNy;
import baseball.veiw.ConsoleResponse;
import baseball.enums.GameMessage;

public class Game {

    public static boolean restart() {
        ConsoleResponse.printMessage(GameMessage.ALL_STRIKE);
        return restartNy(ConsoleResponse.responseMessage(GameMessage.RESTART_NY));
    }

    private static boolean restartNy(String response) {
        return RestartNy.restart(response);
    }


}
