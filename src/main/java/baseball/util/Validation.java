package baseball.util;

import java.util.HashSet;
import java.util.Set;

/**
 *  사용자가 입력한 데이터를 검증하는 클래스
 *   -. 입력받은 문자열 길이 확인(default: 3)
 *   -. 입력받은 문자열 숫자형식, 혹은 0이 아닌지 확인
 *   -. 서로다른 수가 맞는지 체크
 */
public class Validation {
    private static Set<Integer> inputDataToCheckDupl;
    private static int size;

    public Validation() {}

    public Validation(int size) {
        this.size = size;
    }

    public void validateInputData(String input) {
        if (input.length() != this.size) {
            throw new IllegalArgumentException("입력길이확인");
        }
        inputDataToCheckDupl = new HashSet<>();
        for (int i = 0; i < this.size; i++) {
            validateZeroAndType(input.charAt(i));
            inputDataToCheckDupl.add(input.charAt(i) - '0');
        }
        checkDuplication();
    }

    private static void validateZeroAndType(char chr) {
        int num = chr - '0';
        if (num < 0 || num > 9) {
            throw new IllegalArgumentException("잘못된타입");
        }
        if (num == 0) {
            throw new IllegalArgumentException("0입력불가");
        }
    }

    private static void checkDuplication() {
        if (inputDataToCheckDupl.size() != size) {
            throw new IllegalArgumentException("중복데이터입력");
        }
    }
}
