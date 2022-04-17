package baseball.input;

public enum InputErrorEnum {
    DUPLICATE("서로 다른 숫자를 입력해주세요."),
    NOT_THREE_DIGITS("세자리를 입력해주세요."),
    NOT_NUMERIC("숫자가 입력되지 않았습니다."),
    NOT_POSITIVE("음수가 입력되었습니다.");

    private final String value;

    InputErrorEnum(String value) {
        this.value = value;
    }

    public String text() {
        return this.value;
    }
}
