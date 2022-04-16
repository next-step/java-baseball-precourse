package baseball.utils;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Validator {
    private static final int COUNT = 3;
    private static final String NUMBER_RANGE_REGEX = "^[1-9]{3}$"; //3자리 확인, 1~9까지 숫자 확인
    private static final String NUMBER_DUPLICATE_REGEX = "^(?!.*(.).*\\1)\\d{3}$"; // 숫자 중복 확인
    private static final String EXIT_REGEX = "^[1-2]{1}$";

    public void validInputNumber(String input) {
        if(!Pattern.compile(NUMBER_RANGE_REGEX).matcher(input).matches()) {
            throw new IllegalArgumentException();
        }

        if(!Pattern.compile(NUMBER_DUPLICATE_REGEX).matcher(input).matches()) {
            throw new IllegalArgumentException();
        }
    }

    public void validExit(String input) {
        if(!Pattern.compile(EXIT_REGEX).matcher(input).matches()) {
            throw new IllegalArgumentException();
        }
    }
}
