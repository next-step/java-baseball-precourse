package baseball.model;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomNumber {

    public List<Integer> getGenerateNumber() {
        return generate();
    }

    public List<Integer> generate() {
        Set<Integer> numberSet = new HashSet<>();

        while (numberSet.size() < 3) {
            numberSet.add(Randoms.pickNumberInRange(1, 9));
        }

        return new ArrayList<>(numberSet);
    }

}
