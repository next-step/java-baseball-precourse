package baseball.application;

import static baseball.util.BallListGenerator.*;

import baseball.code.ErrorMessage;
import baseball.code.GameStatus;
import baseball.exception.GameException;
import baseball.domain.BallList;
import baseball.domain.GameResult;
import baseball.util.BallListGenerator;
import baseball.ui.InputView;
import baseball.ui.OutputView;

public class BaseballService {

    public static BallList generateComputerBallList() {
        return new BallList(BallListGenerator.generateComputerBallList());
    }

    public static BallList inputUserBall() {
        try {
            String inputUserBallList = InputView.enterValue();
            return generateUserBallList(inputUserBallList);
        } catch (GameException baseballException) {
            OutputView.error(baseballException);
            return inputUserBall();
        }

    }

    public static GameResult baseballResult(BallList computerBallList, BallList userBallList) {
        return computerBallList.ballCount(userBallList);
    }

    public static GameStatus checkGameStatus(GameResult baseballResult) {
        OutputView.ballCount(baseballResult.generateBallCountString());
        if (baseballResult.getStrike() == 3) {
            OutputView.endGame();
            return toBeContinue();
        }
        return GameStatus.CONTINUE_GAME;
    }

    private static GameStatus toBeContinue() {
        try {
            return validateDecideRestart();

        } catch (GameException baseballException) {
            OutputView.error(baseballException);
            return toBeContinue();
        }
    }

    private static GameStatus validateDecideRestart() {
        String decideRestart = InputView.decideRestart();
        if (!decideRestart.equals(GameStatus.RESTART_GAME.getGameStatus())
                && !decideRestart.equals(GameStatus.END_GAME.getGameStatus())) {
            throw new GameException(ErrorMessage.INVALID_DECIDE_RESTART_STRING.getErrorMessage());
        }
        if (decideRestart.equals(GameStatus.END_GAME.getGameStatus())) {
            return GameStatus.END_GAME;
        }
        return GameStatus.RESTART_GAME;
    }
}
