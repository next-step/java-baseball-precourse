package baseball.game;

import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class GameUtil {

    public static List<Integer> randomNumbers(int numNumbers, int start, int end) {
        Set<Integer> result = new LinkedHashSet<>();

        while (result.size() < numNumbers) {
            int picked = pickNumberInRange(start, end);
            result.add(picked);
        }
        return new ArrayList<>(result);
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
