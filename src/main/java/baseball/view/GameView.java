package baseball.view;

import baseball.model.Computer;
import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;

public class GameView {

    public static void inputView() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static String finishCheckView(String input) {
        if (input.equals("3")) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
                + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            input = Console.readLine();
        }

        if (input.equals("1")) {
            Computer.getInstance().reset();
        }

        return input;
    }

    public static void endView(String input) {
        if (input.equals("2"))
            System.out.println("게임 종료");
    }

    public static void printResultView(HashMap<String, Integer> ballStrike) {
        if (ballStrike.get("볼").equals(0) && ballStrike.get("스트라이크").equals(0))
            System.out.println("낫싱");

        if (!ballStrike.get("볼").equals(0) && ballStrike.get("스트라이크").equals(0))
            System.out.println(ballStrike.get("볼") + "볼");

        if (ballStrike.get("볼").equals(0) && !ballStrike.get("스트라이크").equals(0))
            System.out.println(ballStrike.get("스트라이크") + "스트라이크");

        if (!ballStrike.get("볼").equals(0) && !ballStrike.get("스트라이크").equals(0))
            System.out.println(ballStrike.get("볼") + "볼 " + ballStrike.get("스트라이크") + "스트라이크");
    }
}
