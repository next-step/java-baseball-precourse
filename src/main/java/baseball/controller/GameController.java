package baseball.controller;

import baseball.service.GameService;
import baseball.view.InputView;

public class GameController {
    private final InputView inputView;

    public GameController() {
        this.inputView = new InputView();
    }

    public void run() {
        while (true) {
            new GameService().playGame();
            if (inputView.restartGameByPrompt().equals("2")) {
                break;
            }
        }
    }

}
