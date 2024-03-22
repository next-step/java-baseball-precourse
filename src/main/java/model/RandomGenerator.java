package model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomGenerator {
    private static final List<Integer> nums = Arrays.asList(1, 2, 3,4, 5, 6, 7, 8, 9);

    public List<Integer> generateRandomNumber(int numOfDigit) {
        Collections.shuffle(nums);
        return nums.subList(0, numOfDigit);
    }
}
