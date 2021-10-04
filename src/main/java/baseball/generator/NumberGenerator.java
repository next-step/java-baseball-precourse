package baseball.generator;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberGenerator {

    private NumberGenerator() {
    }

    public static List<Integer> makeThreeDigits() {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            final int number = Randoms.pickNumberInRange(1, 9);
            validateNumber(answer, number);
        }
        return answer;
    }

    private static void validateNumber(List<Integer> answer, int number) {
        if (!answer.contains(number)) {
            answer.add(number);
        }
    }
}