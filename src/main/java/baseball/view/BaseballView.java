package baseball.view;

import baseball.domain.Player;
import baseball.domain.Score;
import camp.nextstep.edu.missionutils.Console;

public class BaseballView {

    public static Player inputNumber() {
        System.out.print("숫자를 입력해주세요: ");
        String input = Console.readLine();

        return new Player(input);
    }

    public static Boolean gameResult(Score score) {
        String viewString = "";
        viewString = getMessage(score, viewString);
        System.out.println(viewString);
        if (score.getStrike() == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    private static String getMessage(Score score, String viewString) {
        if (score.getBall() > 0) {
            viewString += score.getBall() + "볼 ";
        }
        if (score.getStrike() > 0) {
            viewString += score.getStrike() + "스트라이크";
        }
        if (viewString.equals("")) {
            viewString += "낫싱";
        }
        return viewString;
    }
}
