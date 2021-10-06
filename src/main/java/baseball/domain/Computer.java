package baseball.domain;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {

    public static final int START_NUM = 1;
    public static final int END_NUM = 9;
    public static final int MAX_COUNT = 3;

    public static List<Integer> createComputerBall() {
        Set<Integer> number = new HashSet<>();
        while (number.size() < MAX_COUNT) {
            number.add(Randoms.pickNumberInRange(START_NUM, END_NUM));
        }
        System.out.println("computer: " + number.toString());
        return new ArrayList<>(number);
    }

}
