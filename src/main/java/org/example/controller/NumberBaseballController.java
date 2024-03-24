package org.example.controller;

import org.example.model.GameStatus;
import org.example.model.NumberBaseball;
import org.example.model.NumberBaseballValidator;
import org.example.support.NumberBaseballException;

import java.util.Scanner;

public class NumberBaseballController {

    private static final Scanner sc = new Scanner(System.in);
    private final NumberBaseball numberBaseball;
    private final NumberBaseballValidator numberBaseballValidator;

    public NumberBaseballController(NumberBaseball numberBaseball) {
        this.numberBaseball = numberBaseball;
        this.numberBaseballValidator = new NumberBaseballValidator();
    }

    public void play() {
        while (numberBaseball.getGameStatus().isStart()) {
            String userNumberInput = getUserInput();
            if (isValidUserNumber(userNumberInput)) {
                numberBaseball.play(Integer.parseInt(userNumberInput));
            }
        }

        String userCommandInput = getUserInput();
        if (isValidUserCommand(userCommandInput)) {
            if (Integer.parseInt(userCommandInput) == UserCommand.RESTART.getValue()) {
                numberBaseball.reset();
                play();
            }
        }
    }

    public String getUserInput() {
        printInfoMessage();
        return sc.nextLine();
    }

    private void printInfoMessage() {
        GameStatus gameStatus = numberBaseball.getGameStatus();
        gameStatus.printMessage();
    }

    private boolean isValidUserNumber(String input) {
        try {
            numberBaseballValidator.validateDigit(input);
            numberBaseballValidator.validateLength(input);
            numberBaseballValidator.validateUniqueCondition(input);
        } catch (NumberBaseballException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private boolean isValidUserCommand(String input) {
        try {
            numberBaseballValidator.validateDigit(input);
            numberBaseballValidator.validateCommand(input);
        } catch (NumberBaseballException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
