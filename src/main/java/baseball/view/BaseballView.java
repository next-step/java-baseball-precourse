package baseball.view;

import nextstep.utils.Console;

public class BaseballView {
    private final String INPUT_MSG = "숫자를 입력해주세요 : ";
    private final String END_GAME_MSG_1 = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";
    private final String END_GAME_MSG_2 =  "게임을 새로 시작하려면 1,종료하려면 2를 입력하세요.";
    private final String INVALID_INPUT = "[ERROR] 잘못된 입력입니다.";

    public String inputPlayerNum() {
        System.out.print(INPUT_MSG);
        return Console.readLine();
    }

    public void printEndGameMsg1() {
        System.out.println(END_GAME_MSG_1);
    }

    public void printEndGameMsg2() {
        System.out.println(END_GAME_MSG_2);
    }

    public String endGameOrNot() {
        return Console.readLine();
    }

    public void printResult(String result) {
        System.out.println(result);
    }

    public void printInvalidInput() {
        System.out.println(INVALID_INPUT);
    }

}
