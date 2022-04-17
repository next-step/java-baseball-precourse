package baseball.game;

import baseball.game.util.Random;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static baseball.game.GameConfig.*;

class GameUtil {
    private GameUtil() { }

    static List<Integer> randomNumbers(int numNumbers, int start, int end) {
        Set<Integer> result = new LinkedHashSet<>();

        while (result.size() < numNumbers) {
            int picked = Random.randomIntInRange(start, end);
            result.add(picked);
        }
        return new ArrayList<>(result);
    }

    private static int parseInt(String s) {
        int num;
        try {
            num = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("can't parse " + s);
        }
        if (num < DIGIT_START || num > DIGIT_END) {
            throw new IllegalArgumentException("input must be between " + DIGIT_START + " and " + DIGIT_END);
        }
        return num;
    }

    static NumberToIndex parseDigitsFrom(String s) {
        NumberToIndex result = new NumberToIndex();

        for (String stringNumber: s.split("")) {
            int parsed = parseInt(stringNumber);
            result.put(parsed);
        }
        if (result.size() != NUM_DIGITS) {
            throw new IllegalArgumentException(NUM_DIGITS + " different digits are required");
        }
        return result;
    }
}
