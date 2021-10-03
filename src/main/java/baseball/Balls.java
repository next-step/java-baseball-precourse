package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private List<Ball> balls = new ArrayList<>();


    public Balls() {
        initBalls();
    }

    private void initBalls() {
        for (int i = 0; i < 3; i++) {
            System.out.println(i+1);
            balls.add(Ball.of(i + 1, i));
        }
    }

    public static Balls of() {
        return new Balls();
    }

    public Status playBall(Ball playerBall) {
        return balls.stream()
                    .map(ball -> ball.compareBall(playerBall))
                    .findFirst()
                    .orElse(Status.NOTHING);
    }
}
