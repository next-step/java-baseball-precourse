package baseball.controller;

import baseball.application.BaseballService;
import baseball.code.GameStatus;
import baseball.domain.BallList;
import baseball.domain.GameResult;

public class BaseballController {

    public static void start() {
        GameStatus gameStatus;
        BallList computerBallList = BaseballService.generateComputerBallList();

        do {
            BallList inputUserBallList = BaseballService.inputUserBall();
            GameResult baseballResult = BaseballService.baseballResult(computerBallList, inputUserBallList);
            gameStatus = BaseballService.checkGameStatus(baseballResult);
            computerBallList = generateNewComputerBallList(gameStatus, computerBallList);
        } while (!gameStatus.equals(GameStatus.END_GAME));
    }

    private static BallList generateNewComputerBallList(GameStatus gameStatus, BallList computerBallList) {
        if (gameStatus.equals(GameStatus.RESTART_GAME)) {
            return BaseballService.generateComputerBallList();
        }
        return computerBallList;
    }
}
