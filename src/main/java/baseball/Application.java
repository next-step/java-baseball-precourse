package baseball;

import baseball.controller.BaseBallController;
import baseball.model.Computer;
import baseball.model.Player;

public class Application {
    public static void main(String[] args) {
        BaseBallController baseBallController = new BaseBallController(new Computer(), new Player());
        baseBallController.play();
    }
}
