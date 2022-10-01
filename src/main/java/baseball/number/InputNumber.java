package baseball.number;

import baseball.score.Score;

import java.util.List;
import java.util.Objects;

public class InputNumber {

    private final Index index;
    private final Number number;

    public InputNumber(int index, String inputData) {
        this(index, Integer.parseInt(inputData));
    }

    public InputNumber(int index, int inputNumber) {
        this(new Index(index), new Number(inputNumber));
    }

    public InputNumber(Index index, Number number) {
        this.index = index;
        this.number = number;
    }

    public Score match(TargetNumbers targetNumbers) {
        List<TargetNumber> targetNumberList = targetNumbers.getTargetNumberList();
        if (isStrike(targetNumberList)) {
            return Score.STRIKE;
        }

        if (isBall(targetNumberList)) {
            return Score.BALL;
        }

        return Score.NOTHING;
    }

    private boolean isStrike(List<TargetNumber> targetNumberList) {
        return equalsWithInputNumber(targetNumberList.get(index.getIndex()));
    }

    private boolean isBall(List<TargetNumber> targetNumberList) {
        for (TargetNumber targetNumber : targetNumberList) {
            if (equalsWithInputNumber(targetNumber)) {
                return true;
            }
        }
        return false;
    }

    private boolean equalsWithInputNumber(TargetNumber targetNumber) {
        return TargetNumber.getCachedTargetNumber(number).equals(targetNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputNumber that = (InputNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
