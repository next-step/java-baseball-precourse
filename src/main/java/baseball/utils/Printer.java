package baseball.utils;

import baseball.domain.Swing;
import baseball.domain.SwingResults;

public class Printer {

    private Printer() {
    }

    public static void swingNumberInput() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void gameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void result(final Swing swing) {
        System.out.println(SwingResults.printMessage(swing));
    }

}
