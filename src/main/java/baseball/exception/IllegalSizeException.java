package baseball.exception;

public class IllegalSizeException extends IllegalArgumentException {
    private static final String MESSAGE = "[ERROR] %s개의 숫자를 입력해주세요";

    public IllegalSizeException(int size) {
        super(String.format(MESSAGE,size));
    }
}
