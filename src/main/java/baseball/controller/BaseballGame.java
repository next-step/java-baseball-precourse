package baseball.controller;

import baseball.model.Computer;
import baseball.util.GameStatus;
import baseball.model.Player;
import baseball.model.Referee;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame implements Game {
    private GameStatus gameStatus;
    private Computer computer;
    private Player player;
    private Referee referee;

    @Override
    public void init() {
        gameStatus = GameStatus.READY;
        computer = new Computer();
        player = new Player();
        referee = new Referee();
    }

    @Override
    public void start() {
        do {
            init();
            playBaseballGame();
        } while(selectRestart());
    }

    private void playBaseballGame() {
        gameStatus = GameStatus.IN_PROGRESS;

        while(gameStatus == GameStatus.IN_PROGRESS) {
            setRound(InputView.getUserNumbers());
            gameStatus = referee.judge();
            referee.printResult();
        }

        OutputView.printFinish();
    }

    private void setRound(String userNumbers) {
        player.setNumbers(userNumbers);
        referee.init(computer.getNumbers(), player.getNumbers());
    }

    @Override
    public boolean selectRestart() {
        return "1".equals(InputView.getUserChoice());
    }
}
