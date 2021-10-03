package baseball;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {

    private final int startInclusive;
    private final int endInclusive;

    private List<Integer> numbers = new ArrayList<>();

    public NumberGenerator(int startInclusive, int endInclusive) {
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
    }

    public String generateNumbers(int count) {
        numbers = new ArrayList<>();
        while (numbers.size() < count && count < 11) {
           addIfNotPresent(Randoms.pickNumberInRange(startInclusive, endInclusive));
        }
        return convertString(numbers);
    }

    private void addIfNotPresent(int number) {
        if(!numbers.contains(number)) {
            numbers.add(number);
        }
    }

    private String convertString(List<Integer> numberSet) {
        StringBuilder stringBuilder = new StringBuilder();
        for(Integer number : numberSet) {
            stringBuilder.append(number);
        }
        return stringBuilder.toString();
    }
}
