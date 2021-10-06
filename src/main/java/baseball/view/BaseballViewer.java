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
    }

}
