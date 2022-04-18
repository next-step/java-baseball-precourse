package Utils;

import camp.nextstep.edu.missionutils.Randoms;
import config.Policy;

public class RandomNumber {
    public static String[] get(){
        int rangeStart = (int) Math.pow(10, Policy.IN_GAME_NUMBER_LENGTH - 1);
        int rangeEnd = (int) Math.pow(10, Policy.IN_GAME_NUMBER_LENGTH);

        return String.valueOf(Randoms.pickNumberInRange(rangeStart, rangeEnd)).split("");
    }
}
