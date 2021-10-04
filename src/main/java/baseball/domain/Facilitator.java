package baseball.domain;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Facilitator {
    public List<Integer> numbersGenerator() {
        List<Integer> numbers = new ArrayList<>();
        while(numbers.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            if(!numbers.contains(num)) {
                numbers.add(num);
            }
        }
        return numbers;
    }
}