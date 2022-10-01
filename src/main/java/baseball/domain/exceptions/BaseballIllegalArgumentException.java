package baseball.domain.exceptions;

import baseball.domain.ConsoleMessage;

public class BaseballIllegalArgumentException extends IllegalArgumentException {

    public BaseballIllegalArgumentException(ConsoleMessage consoleMessage) {
        super(consoleMessage.getMessage());
    }

    public BaseballIllegalArgumentException(ConsoleMessage consoleMessage, Object... args) {
        super(String.format(consoleMessage.getMessage(), args));
    }
}
