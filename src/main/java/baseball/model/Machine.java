package baseball.model;

import java.util.HashMap;

public class Machine {
    public static HashMap<String, Integer> logic(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        HashMap<String, Integer> ballStrike = new HashMap<>();
        ballStrike.put("볼", 0);
        ballStrike.put("스트라이크", 0);

        for (int i = 0; i < chars2.length; i++) {
            iterate(chars1, chars2[i], i, ballStrike);
        }

        return ballStrike;
    }

    private static void iterate(char[] chars, char ch, int index, HashMap<String, Integer> ballStrike) {
        for (int i = 0; i < chars.length; i++) {
            compare(chars[i], ch, i, index, ballStrike);
        }
    }

    private static void compare(char ch1, char ch2, int i1, int i2, HashMap<String, Integer> ballStrike) {
        if (ch1 == ch2 && i1 == i2) {
            ballStrike.put("스트라이크", ballStrike.get("스트라이크") + 1);
        }

        if (ch1 == ch2 && i1 != i2) {
            ballStrike.put("볼", ballStrike.get("볼") + 1);
        }
    }
}
