package Utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    public static String[] get(){
        return String.valueOf(Randoms.pickNumberInRange(100, 999)).split("");
    }
}
