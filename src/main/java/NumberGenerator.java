import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class NumberGenerator {
    private final Random random;

    NumberGenerator() {
        this.random = new Random();
    }

    private int generateOneNumberBetween(int startInclusive, int endInclusive) {
        return random.nextInt(endInclusive - startInclusive + 1) + startInclusive;
    }

    // [lo, hi] 범위의 난수 length개 생성
    public int[] generateNumbersBetween(int length, int startInclusive, int endInclusive) {
        int[] result = new int[length];
        Set<Integer> existNumberSet = new HashSet<>();
        int ix = 0;
        while (ix < length) {
            int number = generateOneNumberBetween(startInclusive, endInclusive);
            if (!existNumberSet.contains(number)) {
                result[ix] = number;
                existNumberSet.add(number);
                ix++;
            }
        }
        return result;
    }
}
