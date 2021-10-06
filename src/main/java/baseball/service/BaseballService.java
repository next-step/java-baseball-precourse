package baseball.service;

import static baseball.util.BallListGenerator.*;

import java.util.List;

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
}
