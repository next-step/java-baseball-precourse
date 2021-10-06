package baseball.service;

import static baseball.util.BallListGenerator.*;

import java.util.List;

import baseball.code.BallCount;
import baseball.code.ErrorMessage;
import baseball.code.GameStatus;
import baseball.exception.BaseballException;
import baseball.model.BallList;
import baseball.util.BallListGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballService {

    public static BallList generateComputerBallList() {
        return new BallList(BallListGenerator.generateComputerBallList());
    }

    public static BallList inputUserBall() {
        try {
            String inputUserBallList = InputView.enterValue();
            return generateUserBallList(inputUserBallList);
        } catch (BaseballException baseballException) {
            OutputView.error(baseballException);
            return inputUserBall();
        }

    }

    public static List<Integer> ballCount(BallList computerBallList, BallList userBallList) {
        return computerBallList.ballCount(userBallList);
    }

    public static GameStatus checkBallCount(List<Integer> ballCount) {
        OutputView.ballCount(BallCount.toString(ballCount));
        if (ballCount.get(0).equals(3)) {
            OutputView.endGame();
            return toBeContinue();
        }
        return GameStatus.CONTINUE_GAME;
    }

    private static GameStatus toBeContinue() {
        try {
            return validateDecideRestart();

        } catch (BaseballException baseballException) {
            OutputView.error(baseballException);
            return toBeContinue();
        }
    }

    private static GameStatus validateDecideRestart() {
        String decideRestart = InputView.decideRestart();
        if (!decideRestart.equals(GameStatus.RESTART_GAME.getGameStatus())
                && !decideRestart.equals(GameStatus.END_GAME.getGameStatus())) {
            throw new BaseballException(ErrorMessage.INVALID_DECIDE_RESTART_STRING.getErrorMessage());
        }
        if (decideRestart.equals(GameStatus.END_GAME.getGameStatus())) {
            return GameStatus.END_GAME;
        }
        return GameStatus.RESTART_GAME;
    }
}
