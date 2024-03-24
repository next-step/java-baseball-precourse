package controller;

import exception.InvalidInputException;
import model.GameModel;
import model.Score;
import view.GameView;

public class GameController {
    private final GameModel model;
    private final GameView view;

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
    }

    public void startGame() {
        model.resetGame();
        while (model.isGameInProgress()) {
            String input = view.getInput();

            try {
                int[] guess = parseInput(input);
                Score score = model.calculateScore(guess);
                view.displayScore(score);
                checkAndProcessEndOfGame(score);
            } catch (InvalidInputException e) {
                view.displayError(e.getMessage());
            }
        }
    }

    private void checkAndProcessEndOfGame(Score score) {
        if (!score.isGameEnd()) {
            return;
        }

        try {
            askForNewGame();
        } catch (InvalidInputException e) {
            view.displayError(e.getMessage());
            checkAndProcessEndOfGame(score);
        }
    }

    private void askForNewGame() throws InvalidInputException {
        String answer = view.askForNewGame();

        if (answer.equals("1")) {
            model.resetGame();
            return;
        }

        if (answer.equals("2")) {
            model.setGameInProgress(false);
            return;
        }

        throw new InvalidInputException("1 또는 2를 입력해주세요");
    }

    public int[] parseInput(String input) throws InvalidInputException {
        if (input.length() != 3) {
            throw new InvalidInputException("정확히 3자리 숫자를 입력해주세요.");
        }

        int[] arr = parseAndValidateInput(input);

        if (hasDuplicate(arr)) {
            throw new InvalidInputException("모든 숫자는 서로 달라야 합니다.");
        }

        return arr;
    }

    public int[] parseAndValidateInput(String input) throws InvalidInputException {
        if (input.length() != 3) {
            throw new InvalidInputException("정확히 3자리 숫자를 입력해주세요.");
        }

        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            int num = charToDigit(input.charAt(i));
            arr[i] = num;
        }

        return arr;
    }

    private int charToDigit(char c) throws InvalidInputException {
        if (!Character.isDigit(c) || c < '1' || c > '9') {
            throw new InvalidInputException("입력된 숫자는 1부터 9 사이여야 합니다.");
        }
        return c - '0';
    }

    private boolean hasDuplicate(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}