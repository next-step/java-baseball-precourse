package baseball.game.ui.console.output;

public class OutputConsole {

    private final int ballCount;
    private final int strikeCount;

    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    public OutputConsole(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void print() {
        String message = makeMessage();
        System.out.println(message);
    }

    private String makeMessage() {
        int strikeCount = getStrikeCount();
        int ballCount = getBallCount();

        if (ballCount == 0 && strikeCount == 0) {
            return NOTHING;
        }

        return ballMessage(ballCount) + strikeMessage(strikeCount);
    }

    private String ballMessage(int ballCount) {
        if (ballCount == 0) {
            return "";
        }
        return ballCount + BALL + " ";
    }

    private String strikeMessage(int strikeCount) {
        if (strikeCount == 0) {
            return "";
        }
        return strikeCount + STRIKE;
    }

}



