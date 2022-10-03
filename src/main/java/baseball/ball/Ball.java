package baseball.ball;

import java.util.List;
import java.util.Objects;

public class Ball {

    private List<Integer> ballNumbers;

    public Ball(List<Integer> numbers) {
        ballNumbers = numbers;
    }

    public List<Integer> getBallNumbers() {
        return ballNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return ballNumbers.equals(ball.ballNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballNumbers);
    }
}
