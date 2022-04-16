package baseball;

public class GamePrinter {
    private static final String NOTHING = "낫싱";
    private static final String STRIKE = "%d스트라이크";
    private static final String BALL = "%d볼";


    public static void printResult(int strikeCount, int ballCount) {
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println(NOTHING);
            return;
        }
        if (ballCount == 0) {
            System.out.printf(STRIKE + "\n", strikeCount);
            return;
        }
        if (strikeCount == 0) {
            System.out.printf(BALL + "\n", ballCount);
            return;
        }
        System.out.printf(BALL + " " + STRIKE+ "\n", ballCount, strikeCount);
    }
}
