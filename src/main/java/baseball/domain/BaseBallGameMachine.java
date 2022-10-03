package baseball.domain;

import baseball.ui.Input;
import baseball.ui.Output;

public class BaseBallGameMachine {

    private final Input input;
    private final Output output;
    private final PickBallsStrategy pickBallsStrategy;
    private BaseBallGame baseBallGame;

    public BaseBallGameMachine(Input input, Output output, PickBallsStrategy pickBallsStrategy) {
        this.input = input;
        this.output = output;
        this.pickBallsStrategy = pickBallsStrategy;
        setNewGame();
    }

    private void setNewGame() {
        baseBallGame = new BaseBallGame(pickBallsStrategy);
    }

    public void startGame() {
        while (!baseBallGame.isGameEnd()) {
            GameResult gameResult = baseBallGame.playOnce(input.userPickNumbers());
            output.printResult(gameResult.toString());
        }
        wantRetry(input.wantRetry());
    }

    private void wantRetry(int choice) {
        if (choice == 1) {
            setNewGame();
            startGame();
        }
        output.printFinish();
    }
}
