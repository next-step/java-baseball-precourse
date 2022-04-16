package baseball.game;

import java.util.*;

import static baseball.game.GameConfig.*;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public final class GameUtil {

    private GameUtil() { }

    public static List<Integer> randomNumbers(int numNumbers, int start, int end) {
        Set<Integer> result = new LinkedHashSet<>();

        while (result.size() < numNumbers) {
            int picked = pickNumberInRange(start, end);
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

    public static NumberToIndex parseDigitsFrom(String s) {
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

    public static String readLine() {
        return camp.nextstep.edu.missionutils.Console.readLine();
    }

    public static void print(Object o) {
        System.out.print(o.toString());
    }

    public static void print(String s) {
        System.out.print(s);
    }

    public static void println(Object o) {
        System.out.println(o.toString());
    }

    public static void println(String s) {
        System.out.println(s);
    }
}
