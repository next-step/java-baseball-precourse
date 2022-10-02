package baseball.view;

import baseball.controller.RetryAnswer;
import camp.nextstep.edu.missionutils.Console;

public class BaseballInputView {

    private BaseballInputView() {
    }

    public static String readLine() {
        return Console.readLine();
    }

    public static String playerNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        return readLine();
    }

    public static RetryAnswer askPlayNewGame() {
        System.out.println("게임을 새로 시작하려면1, 종료하려면 2를 입력하세요.");
        return RetryAnswer.from(readLine());
    }
}
