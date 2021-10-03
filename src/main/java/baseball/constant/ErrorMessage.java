package baseball.rule;

import static baseball.rule.Rule.MAX_NUMBER_OF_BALL;
import static baseball.rule.Rule.MIN_NUMBER_OF_BALL;

public enum ErrorMessage {

    INVALID_BALL_FORMAT("[ERROR] 유효하지 않은 형식 입니다. 정수만 입력 가능 합니다."),
    INVALID_BALL_RANGE("[ERROR] 유효하지 않은 범위 입니다. 각 자리수는 " + MIN_NUMBER_OF_BALL + "이상 " + MAX_NUMBER_OF_BALL + "이하의 정수로 입력되어야 합니다."),
    DUPLICATED_BALLS("[ERROR] 각 자리수는 서로다른 수이어야 합니다."),
    INVALID_BALLS_LENGTH("[ERROR] 3자리 정수를 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}