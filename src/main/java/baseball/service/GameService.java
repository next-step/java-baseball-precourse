package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.util.Strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameService {
    GameService() {
        throw new IllegalArgumentException("Utility class");
    }

    /**
     * 3자리 숫자 생성
     *
     * @return 중복되지 않는 3자리 랜덤 수 생성
     */
    public static String newNumber() {
        int firstNumber = Randoms.pickNumberInRange(1, 9);
        int secondNumber = pickRandomNumber(Collections.singletonList(firstNumber));
        int thirdNumber = pickRandomNumber(Arrays.asList(firstNumber, secondNumber));
        return Strings.concat(firstNumber, secondNumber, thirdNumber);
    }

    /**
     * 중복된 숫자를 제외한 랜덤 숫자 pick
     *
     * @param pickedNumbers 이미 선택된 숫자
     * @return 이미 선택된 숫자를 제외하고 랜덤 숫자 반환
     */
    public static int pickRandomNumber(List<Integer> pickedNumbers) {
        int number = Randoms.pickNumberInRange(1, 9);

        if (pickedNumbers.contains(number)) {
            return pickRandomNumber(pickedNumbers);
        }

        return number;
    }
}
