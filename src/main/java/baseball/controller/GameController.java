package baseball.controller;

import baseball.service.GameService;
import baseball.view.InputView;

public class GameController {
    private final InputView inputView;

    public GameController() {
        this.inputView = new InputView();
    }

    public void run() {
        boolean restartBool = true;;
        while (restartBool) {
            new GameService().playGame();
            restartBool = restartGameCheck();
        }
    }

    private boolean restartGameCheck() {
        if (inputView.restartGameByPrompt().equals("2")) {
            return false;
        }
        return true;
    }

}
