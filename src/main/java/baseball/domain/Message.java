package baseball.domain;

/**
 * @author theco2de
 * @version 1.0
 * @since 1.0
 */
public enum Message {

    INPUT("숫자를 입력해 주세요 : "),
    STRIKE_BALL("%d스트라이크 %d볼"),
    STRIKE("%d스트라이크"),
    BALL("%d볼"),
    NOTHING("낫싱"),
    WINNING("3개의 숫자를 모두 맞히셨습니다! 게임 끝"),
    EXIT_RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    INPUT_ERROR("[ERROR] 잘못된 입력 값입니다.");
    
    private final String value;

    Message(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
