package baseball;

public class MessagePrinter {

    //TODO : 고민 : static 으로 해도 될까.
    private static final String NOTHING = "낫싱";
    private static final String STRIKE = "%d스트라이크";
    private static final String BALL = "%d볼";
    private static final String ASK_RETRY = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String RETRY = "게임을 다시 시작합니다.";
    private static final String TERMINATE = "게임 종료.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 :";

    public static void printInputMessage() {
        System.out.print(INPUT_MESSAGE);
    }
    public static void printInputNumbers(String read) {
        System.out.println(read);
    }

    public static void printAskRetry() {
        System.out.println(ASK_RETRY);
    }

    public static void printRetry() {
        System.out.println(RETRY);
    }

    public static void printTerminate() {
        System.out.println(TERMINATE);
    }

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
