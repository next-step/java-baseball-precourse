package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseBall {
    public static final int BALL_SIZE = 3;
    public static final int MIN_BALL_NUMBER = 1;
    public static final int MAX_BALL_NUMBER = 9;

    private final List<Ball> balls;

    public BaseBall(List<Integer> ballNumbers) {
        balls = createBalls(ballNumbers);
        validateBallSize();
        validateUniqueBallNumber();
    }

    private List<Ball> createBalls(List<Integer> ballNumbers) {
        List<Ball> balls = new ArrayList<>();
        for (Integer ballNumber: ballNumbers) {
            balls.add(new Ball(ballNumber));
        }
        return balls;
    }

    private void validateBallSize() {
        if (balls.size() != BALL_SIZE) {
            throw new IllegalArgumentException("게임에 필요한 볼 크기와 맞지 않습니다");
        }
    }

    private void validateUniqueBallNumber() {
        Set<Ball> uniqueBalls = new HashSet<>(balls);
        if (uniqueBalls.size() != BALL_SIZE) {
            throw new IllegalArgumentException("중복되는 번호가 있습니다");
        }
    }

    public static BaseBall generateComputerBall() {
        return new BaseBall(Randoms.pickUniqueNumbersInRange(MIN_BALL_NUMBER, MAX_BALL_NUMBER, BALL_SIZE));
    }

    @Override
    public String toString() {
        StringBuilder numberString = new StringBuilder();
        for (Ball ball: balls) {
            numberString.append(ball.getNumber());
        }
        return numberString.toString();
    }
}
