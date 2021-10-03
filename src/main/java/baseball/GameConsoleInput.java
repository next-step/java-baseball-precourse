package baseball;

import nextstep.utils.Console;

public class GameConsoleInput {

    public String getInputKey() {
        String inputKey = null;
        boolean doRepeat = true;

        while (doRepeat) {
            Message.printFinishMessage();
            inputKey = Console.readLine();
            boolean isValidKey = isValidKey(inputKey);
            doRepeat = !isValidKey;
            printErrorMessageIfNotValidKey(isValidKey);
        }
        return inputKey;
    }

    private boolean isValidKey(String value) {
        final int NUMBER_LENGTH = 1;
        return isKey(value) && value.length() == NUMBER_LENGTH;
    }

    private boolean isKey(String value) {
        if(isBlank(value)) {
            return false;
        }
        return value.matches("[1-2]+");
    }

    private void printErrorMessageIfNotValidKey(boolean isValidKey) {
        if(!isValidKey) {
            Message.printKeyErrorMessage();
        }
    }
    ///



    public String getInputNumber() {
        String inputValue = null;
        boolean doRepeat = true;

        while (doRepeat) {
            Message.printStartMessage();
            inputValue = Console.readLine();
            boolean isValidNumber = isValidPolicy(inputValue);
            doRepeat = !isValidNumber;
            printErrorMessageIfNotValid(isValidNumber);
        }

        return inputValue;
    }

    private void printErrorMessageIfNotValid(boolean isValid) {
        if(!isValid) {
            Message.printErrorMessage();
        }
    }

    private boolean isValidPolicy(String value) {
        final int NUMBER_LENGTH = 3;
        return isNumber(value) && value.length() == NUMBER_LENGTH && !containSameNumber(value);
    }

    private boolean containSameNumber(String numbers) {
        boolean contain = false;
        for (int i = 0; i < numbers.length(); i++) {
            String number = String.valueOf(numbers.charAt(i));
            contain = contain(numbers, number);
        }
        return contain;
    }

    private boolean contain(String text, String value) {
        if(text.contains(value)) {
            return true;
        }
        return false;
    }


    private boolean isNumber(String value) {
        if(isBlank(value)) {
            return false;
        }
        return value.matches("[0-9]+");
    }

    private boolean isBlank(String value) {
        return value == null || "".equals(value.trim());
    }
}
