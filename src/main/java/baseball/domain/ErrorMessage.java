package baseball.domain;

public enum ErrorMessage {

    BASEBALL_NUMBER_OUT_OF_RANGE_ERROR("야구 숫자는 %d ~ %d 범위만 지정 가능합니다."),
    BASEBALL_NUMBER_DUPLICATE_ERROR("중복되지 않은 숫자 조합만 허용됩니다."),
    BASEBALL_NUMBER_WORNG_SIZE_ERROR("숫자는 %d자리 조합만 허용됩니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    } 

    public String getMessage() {
        return message;
    }

    public String getMessage(Object... values) {
        return String.format(message, values);
    }
}
