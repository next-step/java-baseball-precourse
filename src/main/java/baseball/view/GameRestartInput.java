package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class GameRestartInput {

    public static String input() {
        System.out.println("게임을새로시작하려면1,종료하려면2를입력하세요.");
        return Console.readLine();
    }

}
