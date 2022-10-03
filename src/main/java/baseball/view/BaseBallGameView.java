package baseball.view;

import baseball.model.Judge;

public class BaseBallGameView {

    public static void printRequestInput() {
        System.out.print("숫자를 입력해주세요: ");
    }

    private static void printStrikeOutThenEndGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void notStrikeOut(Judge judge) {
        if (!judge.isStrikeOut()) {
            System.out.println(judge.makeScore());
            judge.clearBallCount();

        }
    }

    public static void printJudgeResult(Judge judge) {
        if (judge.isStrikeOut()) {
            System.out.println(judge.makeScore());
            printStrikeOutThenEndGame();
            judge.clearBallCount();
        }
    }
}