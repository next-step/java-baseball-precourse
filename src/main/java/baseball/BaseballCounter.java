package baseball;

import java.util.List;

public class BaseballCounter implements Counter {


    public BaseballCounter(BaseballGenerator baseballGenerator) {
    }

    @Override
    public void isValid(List<Integer> numbers) {

    }

    @Override
    public int getBallCount(List<Integer> numbers) {
        return 0;
    }

    @Override
    public int getStrikeCount(List<Integer> numbers) {
        return 0;
    }
}
