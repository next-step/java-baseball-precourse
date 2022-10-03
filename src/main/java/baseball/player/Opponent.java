package baseball.player;

import baseball.ball.Ball;

import java.util.List;

public class Opponent implements Player<List<Integer>> {

    @Override
    public Ball createBall(List<Integer> numbers) {
        return new Ball(numbers);
    }

}
