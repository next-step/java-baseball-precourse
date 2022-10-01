package baseball.number;

import baseball.score.Score;

import java.util.ArrayList;
import java.util.List;

import static baseball.number.NumberConstant.COUNT_OF_NUMBERS;
import static baseball.number.NumberConstant.INITIAL_INDEX;

public class InputNumbers {
    private final List<InputNumber> inputNumberList;

    public InputNumbers(String inputData) {
        inputNumberList = new ArrayList<>();

        String[] splitNumbers = inputData.split("");
        if (splitNumbers.length != COUNT_OF_NUMBERS) {
            throw new IllegalArgumentException(COUNT_OF_NUMBERS + "개의 숫자를 입력해주세요.");
        }

        for (int i = INITIAL_INDEX; i < COUNT_OF_NUMBERS; i++) {
            inputNumberList.add(new InputNumber(i, splitNumbers[i]));
        }
    }

    public List<Score> match(TargetNumbers targetNumbers) {
        List<Score> scores = new ArrayList<>();
        for (InputNumber inputNumber : inputNumberList) {
            scores.add(inputNumber.match(targetNumbers));
        }
        return scores;
    }

    public List<InputNumber> getInputNumberList() {
        return inputNumberList;
    }
}
