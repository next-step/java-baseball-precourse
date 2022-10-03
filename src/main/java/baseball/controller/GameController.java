package baseball.controller;

import static baseball.type.GameOverType.RESTART;
import static baseball.view.View.printFinish;
import static baseball.view.View.printHint;
import static baseball.view.View.printInputNumber;
import static baseball.view.View.printRestartOrFinish;

import baseball.domain.Hint;
import baseball.domain.input.InputGameOver;
import baseball.domain.input.InputPlayerNumber;
import baseball.domain.input.factory.InputGameOverFactory;
import baseball.domain.input.factory.InputPlayerNumberFactory;
import baseball.domain.number.ComputerNumber;
import baseball.domain.number.PlayerNumber;
import baseball.type.GameOverType;
import camp.nextstep.edu.missionutils.Console;

public class GameController {

    public void run() {
        do {
            ComputerNumber computerNumber = initializeComputerNumber();
            playBaseballGame(computerNumber);
        } while (isRestartGame());
    }

    private ComputerNumber initializeComputerNumber() {
        return new ComputerNumber();
    }

    private void playBaseballGame(ComputerNumber computerNumber) {
        while (true) {
            printInputNumber();
            Hint hint = new Hint(getPlayerNumber(), computerNumber);
            printHint(hint);
            if (isFinishGame(hint)) {
                printFinish();
                break;
            }
        }
    }

    private PlayerNumber getPlayerNumber() {
        return new InputPlayerNumberFactory(
            new InputPlayerNumber(Console.readLine())
        ).create();
    }

    private boolean isFinishGame(Hint hint) {
        return hint.isThreeStrike();
    }

    private boolean isRestartGame() {
        printRestartOrFinish();
        GameOverType gameOverType = new InputGameOverFactory(
            new InputGameOver(Console.readLine())
        ).create();
        return RESTART == gameOverType;
    }
}
