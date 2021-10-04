package baseball.enums;

import baseball.constant.Const;

public enum ErrorMessageEnum {
    INVALID_LENGTH_ERROR(Const.GENERATE_NUMBER_SIZE + "개의 숫자를 입력해주세요."),
    INVALID_TYPE_ERROR("유효하지 않은 문자입니다. 숫자를 입력해주세요."),
    DUPLICATE_NUMBER_ERROR("중복된 숫자를 입력하였습니다.");

    String message;

    ErrorMessageEnum(String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return this.message;
    }
}
