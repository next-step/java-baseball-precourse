package baseball;

import baseball.controller.BaseballGameController;
import baseball.domain.GameCommand;
import baseball.service.GameNumberGeneratorService;
import baseball.view.Input;

import java.util.Random;

public class Application {
    public static void main(String[] args) {
        GameNumberGeneratorService gameNumberGeneratorService = new GameNumberGeneratorService(new Random());
        BaseballGameController baseballGameController = new BaseballGameController(gameNumberGeneratorService);
        GameCommand gameStatus = Input.command();

        while (gameStatus == GameCommand.START) {
            baseballGameController.process(gameStatus);
            gameStatus = Input.command();
        }
    }
}
