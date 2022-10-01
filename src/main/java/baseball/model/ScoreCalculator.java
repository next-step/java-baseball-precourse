package baseball.model;

public class ScoreCalculator {

    private static final int ZERO = 0;
    private final BallNumbers computerBallNumbers;
    private int strikeCount;
    private int ballCount;

    public ScoreCalculator(BallNumbers computerBallNumbers) {
        this.computerBallNumbers = computerBallNumbers;
        this.strikeCount = ZERO;
        this.ballCount = ZERO;
    }

    public Score calculateScore(BallNumbers userBallNumbers) {
        for (int i = ZERO; i < computerBallNumbers.getNumberSize(); i++) {
            addStrikeCount(userBallNumbers, i);
            addBallCount(userBallNumbers, i);
        }
        return new Score(strikeCount, ballCount);
    }

    private void addBallCount(BallNumbers userBallNumbers, int i) {
        if (isBall(userBallNumbers, i)) {
            ballCount++;
        }
    }

    private void addStrikeCount(BallNumbers userBallNumbers, int i) {
        if (isStrike(userBallNumbers, i)) {
            strikeCount++;
        }
    }

    private boolean isBall(BallNumbers userNumbers, int i) {
        return computerBallNumbers.getBallNumberList().contains(userNumbers.getBallNumberList().get(i))
            && !isStrike(userNumbers, i);
    }

    private boolean isStrike(BallNumbers userNumbers, int i) {
        return computerBallNumbers.getBallNumberList().get(i).equals(userNumbers.getBallNumberList().get(i));
    }

}
