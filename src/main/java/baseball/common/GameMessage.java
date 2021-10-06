package baseball.common;

public enum GameMessage {
    REQ_PROPOSAL_NUMBER("숫자를 입력해 주세요: "),
    ASK_CONTINUE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),

    INCORRECT_VALUE_ERROR("[ERROR] 잘못된 값을 입력하였습니다."),
    NOT_NUMERIC_ERROR("[ERROR] n자리 숫자가 아닙니다."),
    CONTAIN_ZERO_ERROR("[ERROR] 0이 포함되면 안됩니다.");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessageWithReplacedNumber(int replaceNumber) {
        return message.replace("n", Integer.toString(replaceNumber));
    }
}
