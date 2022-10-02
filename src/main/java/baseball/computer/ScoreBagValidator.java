package baseball.computer;

import java.util.HashSet;
import java.util.Set;

public class ScoreBagValidator {

    private final String VALID_MESSAGE = "중복되지 않은 1~9까지의 숫자 3자리를 입력해주세요 (ex.135)";
    public void valid(String input) {

        validLength(input);

        char[] toChar = input.toCharArray();

        validNaturalNumber(toChar);
        validDuplicate(toChar);
        validIncludeZero(toChar);
    }

    // 입력 글자 수 체크
    private void validLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException(VALID_MESSAGE);
        }
    }

    // 정수형 체크
    private void validNaturalNumber(char[] input) {
        for (char c : input) {
            checkNatural(c);
        }
    }

    // 중복 값 체크
    private void validDuplicate(char[] input) {
        Set<Integer> set = new HashSet<>();
        for (char c : input) {
            set.add(Integer.parseInt(String.valueOf(c)));
        }
        if (set.size() != input.length) {
            throw new IllegalArgumentException(VALID_MESSAGE);
        }
    }

    // 0 포함 체크
    private void validIncludeZero(char[] input) {
        for (char c : input) {
            checkZero(c);
        }
    }

    private void checkNatural(char input) {
        try {
            Integer.parseInt(String.valueOf(input));
        } catch (Exception e) {
            throw new IllegalArgumentException(VALID_MESSAGE);
        }
    }

    private void checkZero(char input) {
        if (input == '0') {
            throw new IllegalArgumentException(VALID_MESSAGE);
        }
    }
}
