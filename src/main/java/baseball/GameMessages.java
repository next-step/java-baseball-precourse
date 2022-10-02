package baseball;

public class GameMessages {

    private final static String messageInputWaiting = "숫자를 입력해 주세요 :";
    private final static String messageAnswerIsCorrect = "3개의 숫자를 모두 맞히셨습니다! 게임종료";
    private final static String messageNeedMoreGame = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";
    private final static String messageGameIsEnded = "게임 종료";

    public static void displayCompareResult(int strikes, int balls) {
        System.out.println(getDisplayCompareResult(strikes, balls));
    }
    private static String getDisplayCompareResult(int strikes, int balls) {
        if(strikes + balls == 0)
            return "낫싱";

        if(balls == 0) {
            return strikes + "스트라이크";
        }

        if(strikes ==0) {
            return balls + "볼";
        }

        return balls + "볼 " + strikes + "스트라이크";
    }


    public static void displayWaitInput() {
        System.out.println(messageInputWaiting);
    }

    public static void displayAnswerIsCorrect() {
        System.out.println(messageAnswerIsCorrect);
    }

    public static void displayNeedMoreGame() {
        System.out.println(messageNeedMoreGame);
    }

    public static void displayGameEnded() {
        System.out.println(messageGameIsEnded);
    }
}
