package baseball.number;

import baseball.number.strategy.ExtractNumberStrategy;

import java.util.ArrayList;
import java.util.List;

public class TargetNumbers {

    private final List<TargetNumber> targetNumberList;

    public TargetNumbers(ExtractNumberStrategy extractNumberStrategy) {
        targetNumberList = new ArrayList<>();

        List<Integer> integerList = extractNumberStrategy.extract();
        for (Integer integer : integerList) {
            targetNumberList.add(new TargetNumber(integer));
        }
    }

    public TargetNumbers(String numbers) {
        targetNumberList = new ArrayList<>();

        String[] splitNumbers = numbers.split("");
        for (String splitNumber : splitNumbers) {
            targetNumberList.add(new TargetNumber(splitNumber));
        }
    }

    public List<TargetNumber> getTargetNumberList() {
        return targetNumberList;
    }
}
