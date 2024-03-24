package org.example.support;

import java.util.HashSet;
import java.util.Random;

public class RandomNumberGenerator {

    private static final Random random = new Random();

    private RandomNumberGenerator() {
    }

    public static int generate(int digitLowerBound, int digitUpperBound, int digitCount) {
        HashSet<Integer> set = new HashSet<>();
        while (set.size() < digitCount) {
            int nextRandom = getInclusive(digitLowerBound, digitUpperBound);
            set.add(nextRandom);
        }

        int returnNumber = 0;
        for (int number : set) {
            returnNumber = returnNumber * 10 + number;
        }

        System.out.println(returnNumber);
        return returnNumber;
    }

    private static int getInclusive(int lowerBound, int upperBound) {
        return (random.nextInt(upperBound - lowerBound + 1) + lowerBound);
    }
}
