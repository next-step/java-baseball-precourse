package baseball.controller;

import baseball.domain.Game;
import baseball.domain.GameResult;
import baseball.domain.GameRule;
import baseball.domain.generator.RandomNumbersGenerator;
import baseball.domain.generator.StringNumbersGenerator;
import baseball.domain.player.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallGameController {

    public void startGame() {
        GameRule gameRule = new GameRule(1, 9, 3);
        Player computer = new Player();
        computer.setNumbers(new RandomNumbersGenerator(gameRule).generateNumbers());
        Player user = new Player();
        Game game = new Game(computer, user, gameRule);
        while (!game.isEndGame()) {
            playGame(game);
        }
    }

    private void playGame(Game game) {
        String inputNumbers = InputView.inputNumber();
        game.playGame(
                new StringNumbersGenerator(inputNumbers, game.getGameRule()).generateNumbers()
        );
        GameResult gameResult = game.getGameResult();
        OutputView.printResult(gameResult);
    }
}
