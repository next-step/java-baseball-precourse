package domain;

public class RoundResult {
    private int ballCount;
    private int StrikeCount;

    public int getBallCount() {
        return ballCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public int getStrikeCount() {
        return StrikeCount;
    }

    public void setStrikeCount(int strikeCount) {
        StrikeCount = strikeCount;
    }

    public static RoundResult init(int ballCount, int strikeCount){
        RoundResult roundResult = new RoundResult();
        roundResult.setBallCount(ballCount);
        roundResult.setStrikeCount(strikeCount);

        return roundResult;
    }
}
