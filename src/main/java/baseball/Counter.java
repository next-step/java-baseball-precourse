package baseball;

import java.util.List;

public interface Counter {
    void isValid(List<Integer> numbers);
    int getBallCount(List<Integer> numbers);
    int getStrikeCount(List<Integer> numbers);
}
