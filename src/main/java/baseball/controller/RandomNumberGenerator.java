package baseball.controller;

import nextstep.utils.Randoms;

import java.util.LinkedHashSet;

public class RandomNumberGenerator {

    public String generateRandomNumber() {
        LinkedHashSet<Integer> list = new LinkedHashSet<>();
        int count = 0;
        while(count < 3) {
            count += getUniqueNumber(list);
        }
        return listToString(list);
    }

    private String listToString(LinkedHashSet<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (Integer a : list) {
            sb.append(a);
        }
        return sb.toString();
    }

    private int getUniqueNumber(LinkedHashSet<Integer> list) {
        if (list.add(Randoms.pickNumberInRange(1, 9))) return 1;
        return 0;
    }
}
