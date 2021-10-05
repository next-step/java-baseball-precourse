package baseball.controller;

import baseball.domain.Balls;
import baseball.domain.Computer;
import baseball.domain.GamePlayer;
import baseball.view.InputView;

import static baseball.common.Constants.*;
import static baseball.common.ValidNumber.*;
import static baseball.view.OutputView.getOutPut;


public class BaseBallGameController implements GameController {

    private final InputView inputView;


    public BaseBallGameController() {
        inputView = new InputView();

    }

    public void waitingGame() {
        while (true) {
            StartingGame();
            if (!isContinue()) {
                break;
            }
        }
    }

    public boolean isContinue() {
        while (true) {
            String str = inputView.endingInput();
            if(isNot1And2(str)) {
                System.out.println(EXIT_CONFIRMATION_ERROR_MESSAGE);
                continue;
            }
            if(Integer.parseInt(str) == 1) {
                return true;
            }
            return false;
        }
    }

    @Override
    public void StartingGame() {
        GamePlayer gamePlayer = new GamePlayer();
        Computer computer = new Computer();
        computer.generateBaseballNumber();
        processGame(gamePlayer, computer);
        System.out.println(GAME_RESULT_MESSAGE);

    }


    public void processGame(GamePlayer gamePlayer, Computer computer) {
        do {

            round(gamePlayer, computer);
            getOutPut(getTurnResult(computer, gamePlayer));
            if (isEnd(computer) == true) {
                break;
            }
        } while (true);

    }

    public void round(GamePlayer gamePlayer, Computer computer) {
        boolean flag = false;
        String input;
        do {
            input = inputView.inputNumber();

            if (isNotLength3(input)) {
                System.out.println(INPUT_NUMBER_LENGTH_ERROR_MESSAGE);
                flag = false;
                continue;
            }
            gamePlayer.settingPlayerBalls(input);
            flag = allValidation(gamePlayer.getBalls());

        } while (!flag);

    }

    public boolean allValidation(Balls balls) {
        if (!composeOfDifferentNumbers(balls)) {
            System.out.println(INPUT_RANGE_VALUE_ERROR_MESSAGE);
            return false;
        }
        if (isZero(balls)) {
            System.out.println(INPUT_VALUE_ERROR_MESSAGE);
            return false;
        }
        return true;

    }

    public String getTurnResult(Computer computer, GamePlayer gamePlayer) {
        return computer.getAnswer().calculate(gamePlayer.getBalls());
    }

    public boolean isEnd(Computer computer) {
        return computer.getAnswer().getResult().getStrikeNo() == 3;
    }
}
