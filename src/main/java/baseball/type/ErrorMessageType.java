package baseball.type;

public enum ErrorMessageType {
    LESS_THAN_START_INCLUSIVE("number cannot be less than startInclusive"),
    GREATER_THAN_END_INCLUSIVE("number cannot be greater than endInclusive"),
    INPUT_NOT_ALLOW_BLANK("input not allow blank"),
    INPUT_ONLY_ALLOW_NUMBER("input only allow number"),
    INPUT_ALLOW_JUST_3_DIGIT_NUMBERS("input allow just 3-digit numbers"),
    INPUT_NOT_ALLOW_DUPLICATE("input not allow duplicate");

    private final String message;

    ErrorMessageType(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
