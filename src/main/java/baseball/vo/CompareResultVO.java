package baseball.vo;


public class CompareResultVO {
    private int ballCount;
    private int strikeCount;

    public CompareResultVO(){
        this.ballCount = 0;
        this.strikeCount = 0;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void increaseBallCount(){
        this.ballCount++;
    }

    public void increaseStrikeCount(){
        this.strikeCount++;
    }
}
