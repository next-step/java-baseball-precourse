package baseball.exception;

import static baseball.constant.BaseballProperties.GAME_SIZE;

public enum BaseBallErrorMessage {
    ONLY_NUMERIC_REQUIRED("숫자만 입력할 수 있습니다."),
    INPUT_SIZE_AND_GAME_SIZE_NOT_EQUAL("입력값의 길이는 " + GAME_SIZE + "와(과) 같아야합니다"),
    INPUT_NUMBER_DUPLICATION("중복되지 않는 값을 입력해야합니다."),
    INVALID_GAME_MENU_NUMBER("올바른 명령어를 입력해야합니다.");
    public String errorMessage;

    BaseBallErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

}
