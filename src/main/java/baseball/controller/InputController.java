package baseball.controller;

import baseball.view.Input;

import java.util.List;

public class InputController {

    private final Input input;


    public InputController() {
        this.input = new Input();
    }

    public List InputNumberFromUser() {
        return input.InputNumberFromUser();
    }
}
