package baseball.code;

public enum StatusCode {

    INPUT("잘못된 값을 입력하셨습니다.");

    private String message;

    StatusCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
