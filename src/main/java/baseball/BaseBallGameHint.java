package baseball;

public class BaseBallGameHint {

    private int ballCount;

    private int strikeCount;

    public void increaseStrikeCount() {
        this.strikeCount++;
    }

    public void increaseBallCount() {
        this.ballCount++;
    }

    public boolean isAllStrike() {
        final int ALL_STRIKE_COUNT = 3;

        return this.strikeCount == ALL_STRIKE_COUNT;
    }

    public String toMessage() {
        if (this.ballCount + this.strikeCount == 0) {
            return "낫싱";
        }

        return this.getMessage(this.ballCount, "볼").concat(" ").concat(this.getMessage(this.strikeCount, "스트라이크"))
                .trim();
    }

    private String getMessage(final int count, final String postFix) {
        if (count == 0) {
            return "";
        }

        return count + postFix;
    }

}
