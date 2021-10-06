package baseball.constant;

import static baseball.constant.Rule.*;

public class ErrorMessage {
    public static final String INVALID_BALL_FORMAT = "[ERROR] 유효하지 않은 형식 입니다. 정수만 입력 가능 합니다.";
    public static final String INVALID_RANGE = "[ERROR] 유효하지 않은 범위 입니다";
    public static final String DUPLICATED_BALLS = "[ERROR] 각 자리수는 서로다른 수이어야 합니다.";
    public static final String INVALID_BALLS_LENGTH = "[ERROR] " + COUNT_OF_BALLS + "자리 정수만 입력 가능합니다.";
}