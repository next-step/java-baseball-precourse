package baseball.domain;

public class Referee {
    private static final int MAX_BALL_COUNT = 3;

    public JudgementResult judgement(Balls computerHasBalls, Balls playerHasBalls) {
        JudgementResult judgementResult = new JudgementResult();
        for (int i = 0; i < MAX_BALL_COUNT; i++) {
            CompareResult result = compare(i, computerHasBalls, playerHasBalls);
            judgementResult.add(result);
        }
        return judgementResult;
    }

    private CompareResult compare(int position, Balls computerHasBalls, Balls playerHasBalls) {
        Ball userBall = playerHasBalls.getBall(position);
        Ball computerBall = computerHasBalls.getBall(position);
        if (isStrike(userBall, computerBall)) {
            return CompareResult.STRIKE;
        }
        if (isBall(computerHasBalls, userBall)) {
            return CompareResult.BALL;
        }
        return CompareResult.NOTHING;
    }

    private Boolean isStrike(Ball userBall, Ball computerBall) {
        return userBall.equals(computerBall);
    }

    private Boolean isBall(Balls computerBalls, Ball userBall) {
        return computerBalls.hasBall(userBall);
    }
}
