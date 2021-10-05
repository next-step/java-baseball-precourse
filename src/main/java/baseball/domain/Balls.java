package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private List<Ball> balls;

    public Balls(List<Integer> numbers) {
        this.balls = mapBalls(numbers);
    }

    public List<Ball> mapBalls(List<Integer> numbers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < Game.BALL_MAX_COUNT; i++) {
            balls.add(new Ball(i + 1, numbers.get(i)));
        }
        return balls;
    }

    public int play(List<Integer> balls) {
        int strikeCount = 0;
        for (int i = 0; i < balls.size(); i++) {
            Ball ball = new Ball(i + 1, balls.get(i));
            BallStatus status = this.balls.get(i).play(ball);
            strikeCount = strikeCount + (status.isStrike() ? 1 : 0);
        }
        return strikeCount;
    }
}
