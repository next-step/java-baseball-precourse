package baseball;

import nextstep.utils.Randoms;

import java.util.HashSet;

public class RandomNumberGenerator {

    public String generateRandomNumber() {
        HashSet<Integer> list = new HashSet<>();
        int count = 0;
        while(count < 3) {
            count += getUniqueNumber(list);
        }
        return list.toString();
    }

    private int getUniqueNumber(HashSet<Integer> list) {
        if (list.add(Randoms.pickNumberInRange(1, 9))) return 1;
        return 0;
    }
}
