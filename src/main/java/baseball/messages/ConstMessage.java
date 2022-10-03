package baseball.messages;

public class ConstMessage {
    public static final String HITTER_INPUT_MSG = "숫자를 입력해주세요 : ";

    public static final String STRIKE_MSG = "%d스트라이크";
    public static final String BALL_MSG = "%d볼";
    public static final String NO_HIT_MSG = "낫싱";

    public static final String ERR_COMMON_MSG = " %d부터 %d까지의 서로 다른 %d자리 숫자만 입력 가능 합니다.";
    public static final String ERR_LIMIT_MSG = "%d자리 숫자가 아닙니다.";
    public static final String ERR_DIGIT_MSG = "숫자가 아닌 값이 존재합니다.";
    public static final String ERR_DUPLICATION_MSG = "동일한 값이 존재합니다.";

    public static final String STRIKE_OUT_MSG = "%d개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String PROGRESS_INPUT_MSG = "게임을 새로 시작하려면 %s, 종료하려면 2를 입력하세요.";
}
