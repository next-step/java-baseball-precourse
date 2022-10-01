package baseball.model;

import static baseball.constants.BaseballConstants.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Set;

public class Computer extends Player {

    private Computer(List<Integer> numbers) {
        super(numbers);
    }

    public static Computer create() {
        Set<Integer> numbers = new LinkedHashSet<>();

        while (numbers.size() < MAX_BALL_COUNT) {
            numbers.add(Randoms.pickNumberInRange(MIN_BALL_NUMBER, MAX_BALL_NUMBER));
        }

        return new Computer(setToList(numbers));
    }

    private static List<Integer> setToList(final Set<Integer> numbers) {
        List<Integer> numberList = new ArrayList<>();

        for (int number : numbers) {
            numberList.add(number);
        }

        return numberList;
    }
}
