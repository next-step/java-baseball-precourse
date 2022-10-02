package baseball.domain.player;

import baseball.domain.ball.Balls;
import baseball.domain.result.Result;

public class Computer {

    private final Balls balls;

    private Computer(Balls balls) {
        this.balls = balls;
    }

    public static Computer from(BallGeneratePolicy generatePolicy) {
        return new Computer(generatePolicy.generate());
    }

    public Result check(Player player) {
        return balls.compareTo(player.getBalls());
    }
}
