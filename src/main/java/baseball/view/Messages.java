package baseball.view;

public enum Messages {

    ASK_USER_INPUT("숫자를 입력해주세요 : "),
    NOTIFY_END_OF_GAME("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"),
    ASK_REPLAY("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");

    private String msg;

    Messages(String message) {
        this.msg = message;
    }

    public String getMsg() {
        return this.msg;
    }
}
