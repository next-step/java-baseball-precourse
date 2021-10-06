package baseball.domain;

public enum Message {
    END_GAME ("게임 끝"),
    RESTART_OR_END_GAME ("게임을 새로 시작하려면 1, 종료하려면 1을 제외한 아무 키나 입력하세요."),
    COMPLETE_END_GAME ("게임을 완전히 종료합니다."),
    INPUT_NUMBER ("숫자를 입력해주세요. : ");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
