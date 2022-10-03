package baseball.view;

public class PrintManager {

    public static void printInputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printFinishGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printCheckContinueGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printCount(int strikeCount, int ballCount) {
        printNothing(strikeCount, ballCount);
        printBallCount(ballCount);
        printStrikeCount(strikeCount);
        System.out.println();
    }

    private static void printNothing(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.print("낫싱");
        }
    }

    private static void printBallCount(int ballCount) {
        if (ballCount != 0) {
            System.out.print(ballCount + "볼 ");
        }
    }

    private static void printStrikeCount(int strikeCount) {
        if (strikeCount != 0) {
            System.out.print(strikeCount + "스트라이크 ");
        }
    }
}
