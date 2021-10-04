package baseball.service;

import baseball.controller.InputController;
import baseball.model.GameStatus;
import baseball.model.RandomNumber;

import java.util.List;

public class GameService {

    private final RandomNumber randomNumber;
    private final GameStatus gameStatus;

    public GameService(RandomNumber randomNumber, GameStatus gameStatus) {
        this.randomNumber = randomNumber;
        this.gameStatus = gameStatus;
    }

    public void playGame() {
        List<Integer> baseballNumber = randomNumber.getGenerateNumber();

        while (true) {
            List<Integer> inputNumber = new InputController().InputNumberFromUser();
//            if (gameStatus.isGameStatus(baseballNumber, inputNumber)) {
            if (false) {
                break;
            }
        }
    }

}
