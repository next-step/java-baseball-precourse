package baseball.game.console;

import baseball.utils.Message;
import nextstep.utils.Console;

public class GamePlayConsole extends BaseConsole {

    public GamePlayConsole(int inputLength) {
        super(inputLength);
    }

    @Override
    public String getInputValue() {
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

    @Override
    protected boolean isValidPolicy(String inputValue) {
        return isNumber(inputValue) && inputValue.length() == super.inputLength && !containSameNumber(inputValue);
    }

    @Override
    protected void printErrorMessageIfNotValid(boolean isValid) {
        if(!isValid) {
            Message.printErrorMessage();
        }
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
        return text.contains(value);
    }


    private boolean isNumber(String value) {
        if(super.isBlank(value)) {
            return false;
        }
        return value.matches("[0-9]+");
    }


}
