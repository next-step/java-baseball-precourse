package baseball.view;

import nextstep.utils.Console;

public class BaseballView {
    private final String INPUT_MSG = "숫자를 입력해주세요 : ";
    private final String END_GAME_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 끝\n"
            + "게임을 새로 시작하려면 1,종료하려면 2를 입력하세요.";

    public String inputPlayerNum() {
        System.out.print(INPUT_MSG);
        return Console.readLine();
    }

    public String endGameOrNot() {
        System.out.println(END_GAME_MSG);
        return Console.readLine();
    }

    public void printResult(String result) {
        System.out.println(result);
    }
}
