package baseball.service;

import baseball.ball.Ball;
import baseball.ball.BallCount;
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

    public BallCount judgementBall(Ball computerBall, int[] userInput) {
        Ball ball = new Ball(userInput);
        return computerBall.judgeBallCount(ball);
    }
}
