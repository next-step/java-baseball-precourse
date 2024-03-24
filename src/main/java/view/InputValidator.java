package view;

import domain.baseball.constants.CommandType;

public class InputValidator {

    static final int NUMBER_LENGTH = 3;

    public boolean isValidCommand(int command) {
        return CommandType.QUIT.getNumber() == command || CommandType.RESTART.getNumber() == command;
    }

    public boolean isValidNumber(int number) {

        boolean[] isDigitUsed = new boolean[10];
        int digitCount = 0;
        while (number > 0) {
            int digit = number % 10;
            if (digit == 0 || isDigitUsed[digit]) {
                return false;
            }
            isDigitUsed[digit] = true;
            number /= 10;
            digitCount++;
        }
        return digitCount == NUMBER_LENGTH;
    }
}
