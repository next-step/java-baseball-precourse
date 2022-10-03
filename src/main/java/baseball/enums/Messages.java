package baseball.enums;

public enum Messages {
    START("숫자를 입력해주세요 : "),
    END("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    OPTION("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    ;

    private final String text;

    Messages(String value) {
        this.text = value;
    }

    public String getText() {
        return text;
    }
}
