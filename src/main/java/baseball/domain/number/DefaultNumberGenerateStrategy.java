package baseball.domain.number;

import baseball.contant.BaseballConstant;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class DefaultNumberGenerateStrategy implements NumberGenerateStrategy {

    @Override
    public List<BaseballNumber> generate() {
        Set<BaseballNumber> numbers = new LinkedHashSet<>();

        while (numbers.size() < BaseballConstant.BASEBALL_NUMBERS_SIZE) {
            int number = pickNumber();
            numbers.add(BaseballNumber.from(number));
        }

        return new ArrayList<>(numbers);
    }

    private int pickNumber() {
        return Randoms.pickNumberInRange(
                BaseballConstant.BASEBALL_NUMBER_MIN,
                BaseballConstant.BASEBALL_NUMBER_MAX
        );
    }
}
