package baseball.validate;

import java.util.regex.Pattern;

// 숫자 게임 내에서 입력(ex. readLine)에 대한 유효성 검사는 여기서 진행한다.
public abstract class InputValidator {

    // 1. 입력 값 길이 체크
    public static void validateInputLength(String input){
        if(input.length() != 3){
            throw new IllegalArgumentException("자릿수 입력이 옳바르지 않습니다.");
        }
    }

    // 2. 입력 값 중 숫자 외 값이 있는지 체크
    public static void validateInputNumber(String input){
        if(!Pattern.matches("^[1-9]*$", input)){
            throw new IllegalArgumentException("숫자 외 입력이 확인되었습니다.");
        }
    }
}
