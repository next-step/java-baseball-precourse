package baseball.controller;

import baseball.domain.*;
import baseball.exception.BaseballException;
import baseball.view.BaseballPrint;
import baseball.view.BaseballView;

import java.util.List;

public class BaseballGame {

    private final String RESTART_INPUT = "1";

    private ComputerBaseballNumber computerBaseballNumber = new ComputerBaseballNumber();
    private GameStatus gameStatus = GameStatus.RESTART;

    public void run() {
        do {
            List<Integer> computerNumbers = computerBaseballNumber.createNumbers();
            Balls computerBalls = new Balls(computerNumbers);
            startGame(computerBalls);
        } while (gameStatus == GameStatus.RESTART);
        BaseballPrint.println(Message.COMPLETE_END_GAME.getMessage());
    }

    public void startGame(Balls computerBalls) {
        PlayResult playResult = new PlayResult();

        while (!playResult.isEndGame()) {
            Balls userBalls = new Balls(inputNumber());
            playResult = userBalls.play(computerBalls);
            BaseballPrint.println(playResult.resultMessage().trim());
        }
        String restartInput = BaseballView.view(Message.RESTART_OR_END_GAME);
        this.gameStatus = restartOrEndGame(restartInput);
    }

    public List<Integer> inputNumber() {
        List<Integer> userNumbers;
        try {
            UserBaseballNumber number = new UserBaseballNumber(BaseballView.view(Message.INPUT_NUMBER));
            number.validate();
            userNumbers = number.createNumbers();
        } catch (BaseballException e) {
            BaseballPrint.println(e.getMessage());
            return inputNumber();
        }

        return userNumbers;
    }

    public GameStatus restartOrEndGame(String restartInput) {
        if (RESTART_INPUT.equals(restartInput)) {
            return GameStatus.RESTART;
        }

        return GameStatus.END;
    }
}
