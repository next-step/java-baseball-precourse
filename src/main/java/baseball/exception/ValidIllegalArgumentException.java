package baseball.exception;

public class ValidIllegalArgumentException extends IllegalArgumentException{
    private static final String VALID_MSG = "1또는 2를 입력해야 합니다.";

    public ValidIllegalArgumentException() {
        super(VALID_MSG);
    }
}
