package baseball.controller;

import java.util.List;

import baseball.code.GameStatus;
import baseball.model.BallList;
import baseball.service.BaseballService;

public class BaseballController {

    public static void start() {
        GameStatus gameStatus;
        BallList computerBallList = BaseballService.generateComputerBallList();

        do {
            BallList inputUserBallList = BaseballService.inputUserBall();
            List<Integer> ballCount = BaseballService.ballCount(computerBallList, inputUserBallList);
            gameStatus = BaseballService.checkBallCount(ballCount);
        } while (!gameStatus.equals(GameStatus.END_GAME));
    }
}
