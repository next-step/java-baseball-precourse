package baseball;

import baseball.enums.RestartNy;
import baseball.veiw.ConsoleResponse;
import baseball.enums.GameMessage;

public class Game {

    public static boolean restart() {
        ConsoleResponse.printMessage(GameMessage.ALL_STRIKE);
        String response = ConsoleResponse.responseMessage(GameMessage.RESTART_NY);
        return restartNy(response);
    }

    private static boolean restartNy(String response) {
        return RestartNy.restart(response);
    }


}
