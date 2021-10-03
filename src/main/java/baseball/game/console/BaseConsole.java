package baseball.game.console;

public abstract class BaseConsole {

    public abstract String getInputValue();
    protected abstract boolean isValidPolicy(String inputValue);
    protected abstract void printErrorMessageIfNotValid(boolean isValid);

    protected boolean isBlank(String value) {
        return value == null || "".equals(value.trim());
    }
}
