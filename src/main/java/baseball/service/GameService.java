package baseball.service;

import baseball.model.GameStatus;
import baseball.model.Numbers;
import baseball.view.OutputView;

public class GameService {
    private OutputView outputView;
    private boolean isInning = true;

    public GameService() {
        this.outputView = new OutputView();
    }

    public void playGame() {
        Numbers numbers = new Numbers();
        numbers.generateNumber();
        while (isInning) {
            isInputNumber(numbers);
            isJudge(new GameStatus().isGameStatus(numbers));
        }
    }

    private void isInputNumber(Numbers numbers) {
        if (numbers.inputNumber()) {
            outputView.displayErrorMessage();
            isInputNumber(numbers);
        }
    }

    public void isJudge(GameStatus gameStatus) {
        String gameResult = gameStatus.getResult();
        outputView.displayResults(gameResult);

        if (gameStatus.isWin()) {
            outputView.displayWin();
            isInning = false;
        }
    }

}
