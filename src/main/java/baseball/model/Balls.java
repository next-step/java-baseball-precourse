package baseball.model;

import baseball.model.enums.BallStatus;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> balls;

    public Balls(List<Integer> numbers) {
        this.balls = constructBalls(numbers);
    }

    private List<Ball> constructBalls(List<Integer> numbers) {
        List<Ball> balls = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            Ball ball = new Ball(i, number);
            balls.add(ball);
        }

        return balls;
    }

    public BallStatus compareWith(Ball otherBall) {
        BallStatus resultStatus = BallStatus.NONE;

        for (Ball ball : balls) {
            BallStatus status = ball.compareTo(otherBall);
            resultStatus = resultStatus.replaceIfNotNone(status);
        }

        return resultStatus;
    }
}
