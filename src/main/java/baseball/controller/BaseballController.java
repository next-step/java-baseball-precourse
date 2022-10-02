package baseball.controller;

import baseball.model.Computer;
import baseball.model.User;
import baseball.util.InputValidator;
import baseball.view.GameView;

public class BaseballController {
    private final GameView gameView = new GameView();
    private User user;
    private Computer computer;

    public void start() {
        init();
        play();
    }

    private void play() {
        while (!user.isCorrect()) {
            guess();
        }
        askRestart();
    }

    private void init() {
        user = new User();
        computer = new Computer();
        computer.shuffle();
    }

    private void guess() {
        gameView.requireInput();
        String inputNumber = gameView.getInputNumber();
        gameView.printGuessResult(user.guessAndGetResult(inputNumber, computer.getAnswer()));
    }

    private void askRestart() {
        gameView.printFinish();
        String restart = gameView.getInputNumber();
        InputValidator.validateRestartInput(restart);

        if(restart.equals("1")) {
            start();
        }

        gameView.exit();
    }
}
