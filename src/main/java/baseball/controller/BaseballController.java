package baseball.controller;

import baseball.service.BaseballService;
import baseball.view.GameMessage;
import camp.nextstep.edu.missionutils.Console;

public class BaseballController {

    BaseballService service = new BaseballService();

    public void play() throws IllegalArgumentException {
        settingGame();
        startGame();
        endGame();
        reGameJudgment();
    }

    public void settingGame() {
        service.settingGame();
    }

    public void startGame() {
        service.startGame();
    }

    public void endGame() {
        GameMessage.gameOverMessage();
    }

    public void reGameJudgment() throws IllegalArgumentException {
        GameMessage.currentGameMessage();
        String userInput = Console.readLine();
        if(userInput.equals("1")) {
            play();
        }
    }
}
