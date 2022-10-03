package baseball.view;

public class MessageFormater {

    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";

    public static String getGameRsltMsg(int ball, int strike) {
        String str = new String();
        if (ball > 0) {
            str += (String.format("%d%s ", ball, BALL));
        }
        if (strike > 0) {
            str += (String.format("%d%s", strike, STRIKE));
        }
        if (ball == 0 && strike == 0) {
            str += NOTHING;
        }
        str += "\n";
        return str;
    }
}
