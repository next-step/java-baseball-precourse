package baseball.domain;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumber {
    private final static int MAX_SIZE = 3;
    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 9;

    private List<Integer> numbers;

    public BaseballNumber() {
        this.numbers = new ArrayList<>();
        while (this.numbers.size() != MAX_SIZE) {
            this.numbers.add(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
        }
    }

    public int getValueByIndex(int index){
        return numbers.get(index);
    }
}
