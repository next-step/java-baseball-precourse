package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> ballList;

    public Balls(List<Integer> numbers) {
        this.ballList = createBallList(numbers);
    }

    private static List<Ball> createBallList(List<Integer> numbers) {
        List<Ball> balls = new ArrayList<>();
        for (int number : numbers) {
            balls.add(new Ball(number));
        }
        return balls;
    }

    public boolean hasBall(Ball ball) {
        return ballList.contains(ball);
    }

    public Ball getBall(int position) {
        return this.ballList.get(position);
    }
}
