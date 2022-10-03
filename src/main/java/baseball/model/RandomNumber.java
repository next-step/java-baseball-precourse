package baseball.model;

import baseball.constant.GameEnvironment;
import baseball.util.DataConverter;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RandomNumber {

    private final List<Integer> randomList;

    public RandomNumber() {
        randomList = makeRandomList();
    }

    private List<Integer> makeRandomList() {
        Set<Integer> numberSet = new LinkedHashSet<>();
        while (numberSet.size() != GameEnvironment.NUMBER_SIZE) {
            numberSet.add(Randoms.pickNumberInRange(GameEnvironment.NUMBER_START, GameEnvironment.NUMBER_END));
        }
        return DataConverter.setToList(numberSet);
    }

    public List<Integer> getRandomList() {
        return randomList;
    }
}