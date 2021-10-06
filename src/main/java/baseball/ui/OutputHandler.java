package baseball.ui;

public class OutputHandler {

    private OutputHandler() {
    }

    public static void printGameExit() {
        System.out.println("게임 종료");
    }

    public static void printStrikeOut() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }

    public static void printCount(final String count) {
        System.out.println(count);
    }

    public static void printException(final String message) {
        System.out.println(message);
    }

}
