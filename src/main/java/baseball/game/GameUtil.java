package baseball.game;

import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;

public class GameUtil {

    public static int randomNumber(List<Integer> l) {
        return pickNumberInList(l);
    }

    public static List<Integer> randomNumbers(int numNumbers, Collection<Integer> pool) {
        Set<Integer> newPool = new HashSet<>(pool);
        List<Integer> l = new ArrayList<>();

        for (int i = 0; i < numNumbers; i++) {
            int picked = randomNumber(new ArrayList<>(newPool));
            l.add(picked);
            newPool.remove(picked);
        }
        return l;
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
