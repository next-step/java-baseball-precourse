package baseball.generator;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberGenerator {

    private NumberGenerator() {
    }

    /**
     * 랜덤으로 3자리 숫자 만들기
     * @return
     */
    public static List<Integer> makeThreeDigits() {
        List<Integer> answer = new ArrayList<>();
        while(answer.size() != 3) {
            final int number = Randoms.pickNumberInRange(1, 9);
            validateNumber(answer, number);
        }
        return answer;
    }

    /**
     * 리스트안에 숫자가 중복되는지 체크
     * @param answer
     * @param number
     */
    private static void validateNumber(List<Integer> answer, int number) {
        if (!answer.contains(number)) {
            answer.add(number);
        }
    }
}