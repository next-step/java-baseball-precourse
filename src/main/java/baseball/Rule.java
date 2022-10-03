package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Rule {

    // 자리 수
    public final int NUMBER_OF_DIGITS = 3;
    // 최소 허용 숫자
    public final int MIN_BASEBALL_NUMBER = 1;
    // 최대 허용 숫자
    public final int MAX_BASEBALL_NUMBER = 9;

    public boolean validateNumbers(final List<Integer> numbers) {
        return numbers.size() == NUMBER_OF_DIGITS && !hasSameOrZeroNumber(numbers);
    }

    private boolean hasSameOrZeroNumber(final List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>();
        for (int i = 0; i < numbers.size(); i++) {
            numberSet.add(numbers.get(i));
        }
        return numberSet.contains(0) || numberSet.size() != numbers.size();
    }

    public int countStrike(final List<Integer> source, final List<Integer> target) {
        int strike = 0;
        for (int i = 0; i < NUMBER_OF_DIGITS; i++) {
            if (source.get(i) == target.get(i)) {
                strike++;
            }
        }
        return strike;
    }

    public int countBall(final List<Integer> source, final List<Integer> target) {
        int ball = 0;
        for (int i = 0; i < NUMBER_OF_DIGITS; i++) {
            if (source.get(i) == target.get((i + 1) % 3) || source.get(i) == target.get((i + 2) % 3)) {
                ball++;
            }
        }
        return ball;
    }

}
