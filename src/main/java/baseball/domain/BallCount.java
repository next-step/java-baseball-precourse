package baseball.domain;


public class BallCount {
    private int strikeCount = 0;
    private int ballCount = 0;


    public int getStrikeCount() {
        return this.strikeCount;
    }

    public int getBallCount() {
        return this.ballCount;
    }

    public boolean getIsStrikeOut() {
        return strikeCount == 3;
    }

    public void addStrikeCount() {
        strikeCount += 1;
    }

    public void addBallCount() {
        ballCount += 1;
    }
}
