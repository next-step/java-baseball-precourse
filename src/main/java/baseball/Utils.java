package baseball;

import java.util.ArrayList;

public class Utils {
    public static ArrayList<Integer> stringToTntArray(String input) {
        ArrayList<Integer> list = new ArrayList<>();
        String[] split = input.split("");

        for (String str : split) {
            list.add(Integer.parseInt(str));
        }
        return list;
    }
}
