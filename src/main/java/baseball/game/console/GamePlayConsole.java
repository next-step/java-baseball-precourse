package baseball.game.console;

import baseball.utils.Message;
import nextstep.utils.Console;

import java.util.HashSet;
import java.util.Set;

public class GamePlayConsole extends BaseConsole {

    private final int inputLength;

    public GamePlayConsole(int inputLength) {
        this.inputLength = inputLength;
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
        return isNumber(inputValue) && inputValue.length() == this.inputLength && !containSameNumber(inputValue);
    }

    @Override
    protected void printErrorMessageIfNotValid(boolean isValid) {
        if(!isValid) {
            Message.printErrorMessage();
        }
    }


    private boolean containSameNumber(String numbers) {
        Set<String> numberSet = new HashSet<>();
        for (int i = 0; i < numbers.length(); i++) {
            String number = String.valueOf(numbers.charAt(i));
            numberSet.add(number);
        }
        return numberSet.size() != this.inputLength;
    }

    private boolean isNumber(String value) {
        if(super.isBlank(value)) {
            return false;
        }
        return value.matches("[0-9]+");
    }


}
