package baseball.service;

import baseball.model.BallList;
import baseball.util.BallListGenerator;

public class BaseballService {

    public static BallList generateComputerBallList() {
        return new BallList(BallListGenerator.generateComputerBallList());
    }
}
