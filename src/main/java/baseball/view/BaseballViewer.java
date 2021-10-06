package baseball.view;

import baseball.model.ResultBallCount;
import nextstep.utils.Console;

public class BaseballViewer {

    private final static String RESTART = "1";
    private final static String QUIT = "2";

    public String getUserInput() {
        System.out.print("숫자를 입력해주세요. : ");
        return Console.readLine();
    }

    public void displayResult(ResultBallCount resultBallCount) {
        System.out.println(resultBallCount);
        if(resultBallCount.isOut()){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
        }
    }

    public boolean isRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();

        if (input.equals(RESTART)) {
            return true;
        }

        if (input.equals(QUIT)) {
            return false;
        }

        throw new IllegalArgumentException();
    }

}
