package baseball.exception;

public class IncorrectInputException extends RuntimeException {
    private final String prefix = "[ERROR]";

    public IncorrectInputException() {
        super();
    }

    public IncorrectInputException(String message) {
        super(message);
    }

    public IncorrectInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectInputException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return String.format("%s %s", this.prefix, super.getMessage());
    }
}
