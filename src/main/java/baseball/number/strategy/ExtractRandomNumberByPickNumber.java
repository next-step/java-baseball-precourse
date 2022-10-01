package baseball.number.strategy;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.number.NumberConstant.*;

public class ExtractRandomNumberByPickNumber implements ExtractNumberStrategy {

    @Override
    public List<Integer> extract() {
        List<Integer> integers = new ArrayList<>();
        while (integers.size() < COUNT_OF_NUMBERS) {
            add(integers);
        }
        return integers;
    }

    private void add(List<Integer> integers) {
        int randomNumber = Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);
        if (integers.contains(randomNumber)) {
            return;
        }
        integers.add(randomNumber);
    }
}
