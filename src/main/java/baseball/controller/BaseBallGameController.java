package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.GamePlayer;
import baseball.view.InputView;

import static baseball.view.OutputView.getOutPut;


public class BaseBallGameController implements GameController {

    private final InputView inputView;


    public BaseBallGameController() {
        inputView = new InputView();

    }

    @Override
    public void StartingGame() {
        GamePlayer gamePlayer = new GamePlayer();
        Computer computer = new Computer();
        computer.generateBaseballNumber();
        processGame(gamePlayer, computer);
    }


    public void processGame(GamePlayer gamePlayer, Computer computer) {
        do {

            round(gamePlayer, computer);
        } while (isEnd(gamePlayer));

    }

    public void round(GamePlayer gamePlayer, Computer computer) {
        String input = inputView.inputNumber();
        gamePlayer.settingPlayerBalls(input);
        getOutPut(getTurnResult(computer, gamePlayer));
    }


    public String getTurnResult(Computer computer, GamePlayer gamePlayer) {
        return computer.getAnswer().calculate(gamePlayer.getBalls());
    }

    public boolean isEnd(GamePlayer gamePlayer) {
        return gamePlayer.getBalls().getResult().getStrikeNo() == 3;
    }
}
