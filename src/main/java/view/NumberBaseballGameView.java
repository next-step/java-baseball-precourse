package view;

public class NumberBaseballGameView {

    public static void printInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printResult(int strikeCount, int ballCount) {
        StringBuilder sb = new StringBuilder();

        if (strikeCount > 0) {
            sb.append(strikeCount).append("스트라이크 ");
        }

        if (ballCount > 0) {
            sb.append(ballCount).append("볼");
        }

        if (sb.length() == 0) {
            sb.append("낫싱");
        }

        System.out.println(sb);
    }

    public static void printSuccessMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }

    public static void printContinueGameNotificationMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
