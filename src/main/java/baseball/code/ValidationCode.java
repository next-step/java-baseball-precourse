package baseball.code;

public enum ValidationCode {

    LENGTH("숫자는 세 자리까지 가능합니다."),

    NUMBER("숫자만 입력 가능합니다."),

    OVERLAP("중복된 숫자가 존재합니다.");

    private String message;

    ValidationCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
