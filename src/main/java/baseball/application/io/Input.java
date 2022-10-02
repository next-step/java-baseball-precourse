package baseball.application.io;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public String numbers() {
        return input();
    }

    public Flag restartFlag() {
        return Flag.from(input());
    }

    private String input() {
        return Console.readLine();
    }
}
