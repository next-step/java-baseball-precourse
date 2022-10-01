package baseball.view;

import baseball.model.GameResult;

/**
 * 콘솔 출력
 */
public class GameOutputView {

    /**
     * 게임 플레이어의 수 입력 요청 출력
     */
    public static void printMission() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    /**
     * 게임 결과 출력
     * 게임 플레이어가 몇 개의 볼과 스트라이크를 만들어냈는지 출력
     * @param gameResult 게임 결과(볼, 스트라이크 개수 가짐)
     */
    public static void printMissionResult(GameResult gameResult) {
        int ballCount = gameResult.getBall();
        int strikeCount = gameResult.getStrike();
        if(ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
            return;
        }
        printBall(ballCount);
        printStrike(strikeCount);
    }

    /**
     * 게임 성공 출력
     * @param strikeCount 스트라이크 개수
     */
    public static void printCompleteGame(int strikeCount) {
        System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료%n", strikeCount);
    }

    /**
     * 게임 종료 여부 문의 출력
     */
    public static void printWantGameOver() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    /**
     * 볼 개수 출력
     * @param ballCount 볼 개수
     */
    private static void printBall(int ballCount) {
        if(ballCount > 0) {
            System.out.printf("%d볼 ", ballCount);
        }
    }

    /**
     * 스트라이크 개수 출력
     * @param strikeCount 스트라이크 개수
     */
    private static void printStrike(int strikeCount) {
        if(strikeCount > 0) {
            System.out.printf("%d스트라이크%n", strikeCount);
            return;
        }
        System.out.println();
    }
}
