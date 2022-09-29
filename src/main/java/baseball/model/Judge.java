package baseball.model;

public class Judge {

    private static int ballCount;
    private static int strikeCount;

    private static final int STRIKE_OUT = 3;

    public static int getBallCount() {
        return ballCount;
    }

    public static int getStrikeCount() {
        return strikeCount;
    }

    public static void increaseStrikeCount() {
        strikeCount += 1;
    }

    public static void increaseBallCount() {
        ballCount += 1;
    }

    public Judge() {
        ballCount = 0;
        strikeCount = 0;
    }

    public static Judge resetBallCount() {
        return new Judge();
    }

    public static boolean isStrikeOut() {
        return strikeCount == STRIKE_OUT;
    }
}
