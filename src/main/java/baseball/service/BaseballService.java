package baseball.service;

import baseball.ball.Ball;
import baseball.ball.BallGenerator;


/**
 * @author KingCjy
 */
public class BaseballService {

    private final BallGenerator ballGenerator;

    public BaseballService() {
        ballGenerator = new BallGenerator();
    }

    public Ball generateBall() {
        return ballGenerator.generate();
    }
}
