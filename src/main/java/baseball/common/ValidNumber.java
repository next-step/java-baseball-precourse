package baseball.common;


import baseball.domain.Balls;

import java.util.HashMap;

import static baseball.domain.Ball.isBetween1And9;


public class ValidNumber {

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

    public static boolean isZero(Balls balls) {
        for (int i = 0; i < balls.size(); i++) {
            if (!isBetween1And9(balls.getBall(i).getNumber())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNotLength3(String str) {
        if (str.length() != 3) {
            return true;
        }
        return false;
    }

    public static boolean isNot1And2(String str) {


        if (Integer.parseInt(str) == 1 ||Integer.parseInt(str) == 2) {
            return false;
        }
        return true;
    }

}
