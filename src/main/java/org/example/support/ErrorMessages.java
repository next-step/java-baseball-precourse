package org.example.support;

public enum ErrorMessages {

    NOT_THREE_DIGITS("3자리 숫자가 아닙니다."),
    DUPLICATED_DIGIT("중복된 숫자가 있습니다."),
    INVALID_COMMAND("유효하지 않은 명령입니다."),
    INVALID_DIGIT("1부터 9 사이의 숫자만 입력해주세요.");

    private static final String ERROR_PREFIX = "[ERROR] : ";
    private final String message;

    ErrorMessages(String message) {
        StringBuilder sb = new StringBuilder()
                .append(ERROR_PREFIX)
                .append(message);
        this.message = sb.toString();
    }

    public String getMessage() {
        return message;
    }
}
