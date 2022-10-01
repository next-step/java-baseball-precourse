package baseball.domain;

import static baseball.domain.BaseballNumber.MAX_VALUE;
import static baseball.domain.BaseballNumber.MIN_VALUE;
import static baseball.domain.BaseballNumbers.SIZE;
import static java.lang.String.*;

public enum ConsoleMessage {

    INPUT_BASEBALL_GAME_START("숫자를 입력해주세요"),
    OUTPUT_BASEBALL_GAME_WIN(format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료", SIZE)),
    OUTPUT_BASEBALL_GAME_RESTART(format("게임을 새로시작 하려면 %d,종료하려면 %d를 입력하세요.", 1, 2)),
    OUTPUT_BASEBALL_GAME_RESTART_ERROR("1 또는 2를 입력하세요."),
    EXCEPTION_OUT_OF_BOUNDS_BASEBALL_NUMBER("%d는 %d~%d 범위에 포함되는 숫자가 아닙니다."),
    EXCEPTION_INVALID_BASEBALL_NUMBERS(format("%d~%d 범위에 포함되는 %d개의 숫자로 구성되어야 합니다.", MIN_VALUE, MAX_VALUE, SIZE)),
    EXCEPTION_DUPLICATED_BASEBALL_NUMBERS("중복된 숫자가 포함되어 있습니다.");

    private final String message;

    ConsoleMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
