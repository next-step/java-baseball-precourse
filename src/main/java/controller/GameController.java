package controller;

import exception.GameException;
import model.BaseballNumber;
import model.GameModel;
import model.GameResult;
import view.GameView;
import view.UserCommand;

public class GameController {

    private final GameModel model;
    private final GameView view;

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
    }

    public void play() {
        while (playAgain()) {
            model.reset();
            run();
        }
    }

    private void run() {
        GameResult result = null;
        while (result == null || !result.isOver()) {
            try {
                int input = view.getUserInput();
                BaseballNumber userNumber = BaseballNumber.of(input);
                result = model.getResult(userNumber);
                view.printResult(result);
            } catch (GameException e) {
                System.out.println("[ERROR] " + e.getMessage());
                result = null;
            }
        }
    }

    private boolean playAgain() {
        while (true) {
            try {
                UserCommand userCommand = view.getUserCommand();
                return userCommand.equals(UserCommand.START);
            } catch (GameException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }
}
