package util.numberGenerator;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomNumberGenerator implements NumberGenerator{
    private static final Random random = new Random();

    @Override
    public Set<Integer> generateNumbersBetween(int lowerBound, int upperBound, int n) {
        HashSet<Integer> randomNumbers = new HashSet<>();

        while (randomNumbers.size() < n) {
            int number = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            randomNumbers.add(number);
        }

        return randomNumbers;
    }
}
