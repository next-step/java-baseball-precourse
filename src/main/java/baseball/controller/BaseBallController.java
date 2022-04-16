package baseball.controller;

import baseball.view.InputView;

public class BaseBallController {

    private boolean exit = true;
    private static final String EXIT = "2";

    public void play() {
        while (exit) {
            InputView.inputNumber();
            String exitInput = InputView.inputExit();
            if(isExit(exitInput)) {
                exit = false;
            }
        }
    }

    public boolean isExit(String input) {
        return input.equals(EXIT);
    }
}
