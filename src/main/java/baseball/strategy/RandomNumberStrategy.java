package baseball.strategy;

import java.util.List;

public interface RandomNumberStrategy {
    public abstract List<Integer> getRandomNumberList(final int min, final int max, final int count);
}
