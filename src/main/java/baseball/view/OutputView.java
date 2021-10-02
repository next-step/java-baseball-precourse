package baseball.view;

public class OutputView {

    public static void printResult(String result) {
        System.out.println(result);
    }

    public static void printEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }

    public static void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }

}
