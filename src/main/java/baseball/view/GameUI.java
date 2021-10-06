package baseball.view;

import baseball.domain.PlayResult;
import nextstep.utils.Console;

public class GameUI {

    public static String getBallsValue() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static String getIsRestartValue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

    public static void gameEndMessage() {
        System.out.println("게임을 종료합니다.");
    }

    //== 화면 출력 ==//
    public static void displayPlayResult(PlayResult playResult) {
        int strike = playResult.getStrike();
        int ball = playResult.getBall();

        if (playResult.isNothing()) {
            System.out.println("낫싱");
            return;
        }
        String message = "";
        if (strike > 0) {
            message += strike + "스트라이크 ";
        }
        if (ball > 0) {
            message += ball + "볼 ";
        }
        System.out.println(message);
    }
}
