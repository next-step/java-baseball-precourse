package baseball.number.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static baseball.number.NumberConstant.*;

public class ExtractRandomNumberByShuffleList implements ExtractNumberStrategy {

    @Override
    public List<Integer> extract() {
        List<Integer> integers = new ArrayList<>();
        for (int i = MINIMUM_NUMBER; i <= MAXIMUM_NUMBER; i++) {
            integers.add(i);
        }
        Collections.shuffle(integers);
        return Collections.unmodifiableList(integers.subList(INITIAL_INDEX, COUNT_OF_NUMBERS));
    }
}
