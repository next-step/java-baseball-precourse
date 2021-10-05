package baseball.service;

import baseball.model.GameStatus;
import baseball.model.Numbers;
import baseball.view.OutputView;

public class GameService {
    private OutputView outputView;
    private boolean isInning = true;

    public void playGame() {
        Numbers numbers = new Numbers();
        while (isInning) {
            numbers.generateNumber();
            numbers.inputNumber();
            isJudge(new GameStatus().isGameStatus(numbers));
        }
    }

    public void isJudge(GameStatus gameStatus) {
        if (gameStatus.isWin()) {
            outputView.displayWin();
            isInning = false;
        }

        if (!gameStatus.isWin()) {
            String gameResult = gameStatus.getResult();
            outputView.displayResults(gameResult);
        }
    }

}
