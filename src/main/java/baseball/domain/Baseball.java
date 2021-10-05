package baseball.domain;

import java.util.*;

public class Baseball {

    public static final int BALLSIZE = 3;

    List<Ball> balls;

    public Baseball(List<Integer> numbers) {
        ballSizeCheck(numbers);
        ballDuplicationCheck(numbers);
        this.balls = createBall(numbers);
    }

    private List<Ball> createBall(List<Integer> numbers) {
        List<Ball> resultBalls = new ArrayList<>();
        for (int i = 0; i < BALLSIZE; i++) {
            resultBalls.add(new Ball(i , numbers.get(i)));
        }
        return resultBalls;
    }

    private void ballSizeCheck(List<Integer> numbers) {
        if(sizeCheck(numbers)) {
            throw new IllegalArgumentException("3자리 까지만 가능"); // todo custom class로 변경
        }
    }

    private boolean sizeCheck(List<Integer> numbers) {
        return numbers.size() != BALLSIZE;
    }

    private void ballDuplicationCheck(List<Integer> numbers) {
        if(duplicationCheck(numbers)) {
            throw new IllegalArgumentException("중복 불가"); // todo custom class로 변경
        }
    }

    private boolean duplicationCheck(List<Integer> numbers) {
        return new HashSet<>(numbers).size() != numbers.size();
    }

    public BaseballResult compare(Baseball target) {
        BaseballResult baseballResult = new BaseballResult();
        for (Ball ball : balls) {
            baseballResult.save(compareTarget(ball, target.balls));
        }
        return baseballResult;
    }

    public static BallHint compareTarget(Ball ball, List<Ball> targets) {
        BallHint ballHint = BallHint.NOTHING;
        for (Ball target : targets) {
            ballHint = strikeAndBallCheck(ball, target, ballHint);
        }
        return ballHint;
    }

    private static BallHint strikeAndBallCheck (Ball ball, Ball target, BallHint hint) {
        BallHint ballHint = ball.compare(target);
        if(!ball.compare(target).isNothing()) {
            hint = ballHint;
        }
        return hint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Baseball baseball = (Baseball) o;
        return Objects.equals(balls, baseball.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }

    @Override
    public String toString() {
        return "Baseball{" +
                "balls=" + balls +
                '}';
    }

}
