package baseball.controller;

import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;

public class BullsAndGameController {

    public void start() {
        do {

        } while (restart());
        View.end();
    }

    private boolean restart() {
        View.restart();
        String line = Console.readLine().trim();
        return line.equals("1");
    }
}
