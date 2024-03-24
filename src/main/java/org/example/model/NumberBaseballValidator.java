package org.example.model;

import org.example.controller.UserCommand;
import org.example.support.ErrorMessages;
import org.example.support.NumberBaseballException;

import java.util.HashSet;

public class NumberBaseballValidator {

    public void validateDigit(String input) {
        if (!input.matches("^[1-9]*$")) {
            throw new NumberBaseballException(ErrorMessages.INVALID_DIGIT.getMessage());
        }
    }

    public void validateLength(String input) {
        if (input.length() != Constants.DIGIT_LENGTH) {
            throw new NumberBaseballException(ErrorMessages.NOT_THREE_DIGITS.getMessage());
        }
    }

    public void validateUniqueCondition(String input) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            set.add(input.charAt(i));
        }

        if (set.size() != Constants.DIGIT_LENGTH) {
            throw new NumberBaseballException(ErrorMessages.DUPLICATED_DIGIT.getMessage());
        }
    }

    public void validateCommand(String input) {
        for (UserCommand userCommand : UserCommand.values()) {
            if (Integer.parseInt(input) == userCommand.getValue()) {
                return;
            }
        }
        throw new NumberBaseballException(ErrorMessages.INVALID_COMMAND.getMessage());
    }
}
