package baseball.domain;

import baseball.enums.GameMessage;
import baseball.enums.RestartNy;
import baseball.veiw.ConsoleResponse;

public class Game {

    public static boolean restart() {
        ConsoleResponse.printMessage(GameMessage.ALL_STRIKE);
        return restartNy(ConsoleResponse.responseMessageNext(GameMessage.RESTART_NY));
    }

    private static boolean restartNy(String response) {
        return RestartNy.restartResult(response);
    }


}
