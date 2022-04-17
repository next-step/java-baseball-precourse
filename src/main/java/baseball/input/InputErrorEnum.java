package baseball.input;

public enum InputErrorEnum {
    DUPLICATE("서로 다른 숫자를 입력해주세요."),
    NOT_THREE_DIGITS("세자리를 입력해주세요."),
    NOT_NUMERIC("정상적인 숫자가 입력되지 않았습니다."),
    ALREADY_CHECKED("이미 확인한 값 입니다.");

    private final String value;

    InputErrorEnum(String value) {
        this.value = value;
    }

    public String text() {
        return this.value;
    }
}
