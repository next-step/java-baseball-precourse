package baseball.controller;

import baseball.domain.game.Game;
import baseball.domain.game.GameResult;
import baseball.domain.game.GameRule;
import baseball.domain.game.GameStatus;
import baseball.domain.generator.RandomNumbersGenerator;
import baseball.domain.generator.StringNumbersGenerator;
import baseball.domain.player.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallGameController {

    public void initGame() {
        GameRule gameRule = new GameRule(1, 9, 3);
        Player computer = new Player();
        Player user = new Player();
        Game game = new Game(computer, user, gameRule);
        while (!game.isFinishGame()) {
            startGame(game);
        }
    }

    public void startGame(Game game) {
        game.setGameStatus(GameStatus.START);
        game.setComputerNumbers(new RandomNumbersGenerator(game.getGameRule()).generateNumbers());
        while (!game.isEndGame()) {
            playGame(game);
        }
        checkRestart(game);
    }

    private void playGame(Game game) {
        String inputNumbers = InputView.inputNumber();
        game.playGame(
                new StringNumbersGenerator(inputNumbers, game.getGameRule()).generateNumbers()
        );
        GameResult gameResult = game.getGameResult();
        OutputView.printResult(gameResult);
    }

    private void checkRestart(Game game) {
        String inputRestartInfo = InputView.inputRestartOrFinish();
        game.checkFinish(inputRestartInfo);
    }

}
