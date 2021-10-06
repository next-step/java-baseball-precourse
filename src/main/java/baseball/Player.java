package baseball;

import baseball.veiw.ConsoleResponse;
import baseball.enums.GameMessage;


public class Player {

    public static int createPlayerBall() {
        String response = ConsoleResponse.responseMessage(GameMessage.PLAYER_INPUT_MESSAGE);
        return Integer.parseInt(response);
    }

}
