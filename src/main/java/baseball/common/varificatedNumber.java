package baseball.common;


import baseball.domain.Balls;

import java.util.HashMap;


public class varificatedNumber {

    public static boolean composeOfDifferentNumbers(Balls balls) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < balls.size(); i++) {
            hashMap.put(balls.getBall(i).getNumber(), i);
        }
        if (hashMap.size() == balls.size()) {
            return true;
        }
        return false;
    }
}
