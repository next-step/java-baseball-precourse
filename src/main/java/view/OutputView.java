package view;

public class OutputView {
    public static void printInfo() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    public static void printEnding() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printHint(int numOfStrike, int numOfBall) {
        if (numOfStrike == 0 && numOfBall == 0) {
            System.out.println("낫싱");
            return;
        }

        StringBuilder sb = new StringBuilder();
        if (numOfStrike > 0) sb.append(numOfStrike).append(" 스트라이크");
        if (numOfBall > 0) sb.append(numOfBall).append(" 볼");

        System.out.println(sb);
    }
}
