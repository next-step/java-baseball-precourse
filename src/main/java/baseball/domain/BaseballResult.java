package baseball.domain;

public class BaseballResult {

    private final String resultScore;
    private final boolean isSameNumber;

    public BaseballResult(String resultScore, boolean isSameNumber) {
        this.resultScore = resultScore;
        this.isSameNumber = isSameNumber;
    }

    public String getResultScore() {
        return this.resultScore;
    }

    public boolean isGameOver() {
        return this.isSameNumber;
    }
}
