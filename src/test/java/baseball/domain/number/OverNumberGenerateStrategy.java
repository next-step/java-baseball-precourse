package baseball.domain.number;

import java.util.ArrayList;
import java.util.List;

public class OverNumberGenerateStrategy implements NumberGenerateStrategy {
    @Override
    public List<BaseballNumber> generate() {
        List<BaseballNumber> numbers = new ArrayList<>();
        numbers.add(BaseballNumber.from(1));
        numbers.add(BaseballNumber.from(2));
        numbers.add(BaseballNumber.from(3));
        numbers.add(BaseballNumber.from(4));
        return numbers;
    }
}
