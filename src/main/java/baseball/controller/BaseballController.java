package baseball.controller;

import baseball.model.Computer;
import baseball.model.Game;
import baseball.model.GameResult;
import baseball.model.NumberGenerator;
import baseball.model.Player;
import baseball.view.BaseballInputView;
import baseball.view.BaseballOutputView;

public class BaseballController {

    private final NumberGenerator numberGenerator;

    public BaseballController(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void start() {
        do {
            playGame();
        } while (BaseballInputView.askPlayNewGame() == RetryAnswer.PLAY_NEW_GAME);
        BaseballOutputView.gameEnd();
    }

    public void playGame() {
        Computer computer = new Computer(numberGenerator);
        GameResult result;
        do {
            Player player = Player.from(BaseballInputView.playerNumbers());
            Game game = new Game(computer, player);
            result = game.play();
            BaseballOutputView.showResult(result);
        } while (!result.isGameOver());
    }


}
