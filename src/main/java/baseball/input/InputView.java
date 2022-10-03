package baseball.input;

import baseball.constants.Message;
import baseball.input.bean.Player;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private Player playerNumber;
    public InputView() {
        this.playerNumber = new Player();
    }
    
    public String scanNumber() {
        System.out.println(Message.REQUEST_INPUT_NUMBER);
        return Console.readLine();
    }

    public String scanRestartGame() {
        System.out.println(Message.MSG_REQUEST_RESTART_OR_EXIT);
        return Console.readLine();
    }
}
