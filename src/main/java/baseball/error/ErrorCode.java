package baseball.error;

public interface ErrorCode {

    String VALIDATE_EXCEPTION_IS_NOT_NUMBER_OR_CONTAIN_ZERO = "[ERROR] 문자열이 포함되어 있거나 0이 포함되어 있습니다";
    String VALIDATE_EXCEPTION_IS_NOT_THREE_DIGITS =  "[ERROR] 3자리 수가 아닙니다.";
    String VALIDATE_EXCEPTION_IS_DUPLICATE = "[ERROR] 중복되는 값이 존재합니다.";


}