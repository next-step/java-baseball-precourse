package baseball.domain.number;

import java.util.ArrayList;
import java.util.List;

public class EmptyNumberGenerateStrategy implements NumberGenerateStrategy {
    @Override
    public List<BaseballNumber> generate() {
        return new ArrayList<>();
    }
}
