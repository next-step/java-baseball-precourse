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

    public CompareResult compareWith(List<Integer> numbers) {
        validateCompareListSize(numbers);
        Balls otherBalls = new Balls(numbers);
        CompareResult result = new CompareResult();

        for (Ball ball : balls) {
            BallStatus status = otherBalls.compareWith(ball);
            result.increaseCountByStatus(status);
        }

        return result;
    }

    private void validateCompareListSize(List<Integer> numbers) {
        int numberSize = numbers.size();
        int ballsSize = balls.size();

        if (numberSize != ballsSize) {
            throw new IllegalArgumentException("비교하려는 두 Balls 의 크기가 다릅니다. 입력값:" + numberSize + " 정답:" + ballsSize);
        }
    }

    private BallStatus compareWith(Ball otherBall) {
        BallStatus resultStatus = BallStatus.NONE;

        for (Ball ball : balls) {
            BallStatus status = ball.compareTo(otherBall);
            resultStatus = resultStatus.replaceIfNotNone(status);
        }

        return resultStatus;
    }
}
