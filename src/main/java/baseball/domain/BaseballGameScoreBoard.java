package baseball.domain;

public class BaseballGameScoreBoard {

    private int strikeCount;

    private int ballCount;

    public BaseballGameScoreBoard(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    private boolean is3Strikes() {
        if (strikeCount == 3) {
            return true;
        }
        return false;
    }
}
