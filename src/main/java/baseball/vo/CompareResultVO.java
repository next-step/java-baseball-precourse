package baseball.vo;


public class CompareResultVO {
    private final int ballCount;
    private final int strikeCount;

    public CompareResultVO(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }
}
