package baseball.controller;

import baseball.model.Computer;
import baseball.model.Machine;
import baseball.model.NumberCheckUtil;
import baseball.view.GameView;
import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;

public class GameController {
    public static void gameStart() throws IllegalArgumentException {
        String input = "";

        while (!input.equals("2")) {
            input = play(input);
            input = GameView.finishCheckView(input);
        }

        GameView.endView(input);
    }

    private static String play(String input) {
        if (input.equals("2")) {
            return input;
        }

        input = input();

        if (!NumberCheckUtil.isValid(input)) {
            return input;
        }

        HashMap<String, Integer> ballStrike = Machine.logic(Computer.getInstance().getNumber(), input);
        GameView.printResultView(ballStrike);

        return ballStrike.get("스트라이크") == 3? "3" : input;
    }

    private static String input() {
        GameView.inputView();
        return Console.readLine();
    }

}
