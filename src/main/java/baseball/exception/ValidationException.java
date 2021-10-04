package baseball.exception;

import baseball.message.error.ErrorCode;

public class ValidationException extends BusinessException {
    public ValidationException(ErrorCode errorCode) {
        super(errorCode);
    }
}
