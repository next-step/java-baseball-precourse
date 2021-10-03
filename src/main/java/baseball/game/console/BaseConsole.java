package baseball.game.console;

public abstract class BaseConsole {

    protected final int inputLength;

    protected BaseConsole(int inputLength) {
        this.inputLength = inputLength;
    }

    public abstract String getInputValue();
    protected abstract boolean isValidPolicy(String inputValue);
    protected abstract void printErrorMessageIfNotValid(boolean isValid);

    protected boolean isBlank(String value) {
        return value == null || "".equals(value.trim());
    }
}
