package baseball.domain;

public class GameResult {
    private final int STRIKE_OUT = 3;
    private int strikeCnt = 0;
    private int ballCnt = 0;

    public void setStrike() {
        this.strikeCnt++;
    }

    public void setBall() {
        this.ballCnt++;
    }

    public int getStrikeCnt() {
        return strikeCnt;
    }

    public int getBallCnt() {
        return ballCnt;
    }

    public boolean isGameOver() {
        return getStrikeCnt() == STRIKE_OUT;
    }
}
