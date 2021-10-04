package view;

import nextstep.utils.Console;

public class InputView {

    public static String insertBallNumbers() {
        System.out.println();
        System.out.println("숫자를입력해주세요:");
        return Console.readLine();
    }
    public static int insertSelectGameContinue() {
        System.out.println("3개의숫자를모두맞히셨습니다!게임끝");
        System.out.println("게임을새로시작하려면1,종료하려면2를입력하세요.");
        return Integer.parseInt(Console.readLine());
    }
}
