package domain;

public class RoundResult {
    private int ballCount;
    private int strikeCount;

    public int getBallCount() {
        return ballCount;
    }

    private void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    private void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }

    public static RoundResult init(int ballCount, int strikeCount){
        RoundResult roundResult = new RoundResult();
        roundResult.setBallCount(ballCount);
        roundResult.setStrikeCount(strikeCount);

        return roundResult;
    }

    public void addStrike(){
        this.strikeCount++;
    }

    public void addBall(){
        this.ballCount++;
    }
}
