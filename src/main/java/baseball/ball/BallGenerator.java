package baseball.ball;

import nextstep.utils.Randoms;

import java.util.HashSet;
import java.util.Set;

/**
 * @author KingCjy
 */
public class BallGenerator {

    public Ball generate() {
        Set<Integer> numbers = generateNumberSet();
        int[] numberArray = setToIntArray(numbers);

        return new Ball(numberArray);
    }

    private Set<Integer> generateNumberSet() {
        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < 3) {
            numbers.add(Randoms.pickNumberInRange(1, 9));
        }

        return numbers;
    }

    private int[] setToIntArray(Set<Integer> numbers) {
        int[] result = new int[numbers.size()];

        int i = 0;
        for (Integer number : numbers) {
            result[i] = number;
            i++;
        }

        return result;
    }
}
