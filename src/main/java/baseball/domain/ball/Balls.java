package baseball.domain.ball;

import baseball.exception.BaseBallException.DuplicatedBallsException;
import baseball.exception.BaseBallException.InvalidBallsLength;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static baseball.constant.Rule.COUNT_OF_BALLS;

public class Balls {

    private final List<Ball> balls;

    private Balls(List<Ball> balls) {
        validateLength(balls);
        this.balls = balls;
    }

    public static Balls valueOf(List<Integer> input) {
        List<Ball> balls = asBalls(input);
        validateDuplication(input, balls);
        return new Balls(balls);
    }

    private static List<Ball> asBalls(List<Integer> balls) {
        Set<Ball> removeDuplicationBalls = new LinkedHashSet<>();
        for (Integer ball : balls) {
            removeDuplicationBalls.add(new Ball(ball));
        }
        return new ArrayList<>(removeDuplicationBalls);
    }

    private static void validateDuplication(List<Integer> input, List<Ball> balls) {
        if (balls.size() < input.size()) {
            throw new DuplicatedBallsException();
        }
    }

    private void validateLength(List<Ball> balls) {
        if (balls == null || balls.size() != COUNT_OF_BALLS) {
            throw new InvalidBallsLength();
        }
    }

    public List<Ball> getValue() {
        return balls;
    }

    public int getSize() {
        return balls == null ? 0 : balls.size();
    }

}
