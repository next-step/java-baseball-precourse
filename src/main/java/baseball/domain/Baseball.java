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
        if(numbers.size() != BALLSIZE) {
            throw new IllegalArgumentException("3자리 까지만 가능"); // todo custom class로 변경
        }
    }

    private void ballDuplicationCheck(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if(set.size() != numbers.size()) {
            throw new IllegalArgumentException("중복 불가"); // todo custom class로 변경
        }
    }

    // todo depth 2 리팩토링
    public BaseballResult compare(Baseball target) {
        BaseballResult baseballResult = new BaseballResult();
        for (Ball ball : balls) {
            for (Ball targetBall : target.balls) {
                baseballResult.save(ball.compare(targetBall));
            }
        }
        return baseballResult;
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
