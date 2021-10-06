package baseball.controller;

import baseball.code.GameStatus;
import baseball.model.BallCount;
import baseball.model.BallList;
import baseball.service.BaseballService;

public class BaseballController {

    public static void start() {
        GameStatus gameStatus;
        BallList computerBallList = BaseballService.generateComputerBallList();

        do {
            BallList inputUserBallList = BaseballService.inputUserBall();
            BallCount ballCount = BaseballService.ballCount(computerBallList, inputUserBallList);
            gameStatus = BaseballService.checkBallCount(ballCount);
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
