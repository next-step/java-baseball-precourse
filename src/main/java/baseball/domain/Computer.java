package baseball.domain;

import baseball.constant.Const;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final List<Integer> numbers = new ArrayList<>(Const.GENERATE_NUMBER_SIZE);

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void initNumber() {
        numbers.clear();
        while(numbers.size() < Const.GENERATE_NUMBER_SIZE) {
            addNumber(generateRandomNumber());
        }
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(Const.RANDOM_MIN_RANGE, Const.RANDOM_MAX_RANGE);
    }

    private void addNumber(int generateNumber) {
        if (numbers.contains(generateNumber)) {
            return;
        }
        numbers.add(generateNumber);
    }

}
