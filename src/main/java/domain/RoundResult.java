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

    public static RoundResult init(){
        RoundResult roundResult = new RoundResult();
        roundResult.setBallCount(0);
        roundResult.setStrikeCount(0);

        return roundResult;
    }

    public void addStrike(){
        this.strikeCount++;
    }

    public void addBall(){
        this.ballCount++;
    }
}
