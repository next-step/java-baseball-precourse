package baseball.game.console;

import baseball.utils.Message;
import nextstep.utils.Console;

public class GameOverConsole extends BaseConsole {

    private final int inputLength;

    public GameOverConsole(int inputLength) {
        this.inputLength = inputLength;
    }

    @Override
    public String getInputValue() {
        String inputValue = null;
        boolean doRepeat = true;

        while (doRepeat) {
            Message.printFinishMessage();
            inputValue = Console.readLine();
            boolean isValidKey = isValidPolicy(inputValue);
            doRepeat = !isValidKey;
            printErrorMessageIfNotValid(isValidKey);
        }
        return inputValue;
    }

    @Override
    protected boolean isValidPolicy(String inputValue) {
        return isKey(inputValue) && inputValue.length() == inputLength;
    }

    @Override
    protected void printErrorMessageIfNotValid(boolean isValid) {
        if(!isValid) {
            Message.printKeyErrorMessage();
        }
    }

    private boolean isKey(String value) {
        if(super.isBlank(value)) {
            return false;
        }
        return value.matches("[1-2]+");
    }


}
