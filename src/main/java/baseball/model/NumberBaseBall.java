package baseball.model;

import baseball.code.ValidationCode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberBaseBall {

    private List<Integer> baseBalls = new ArrayList<>();

    public NumberBaseBall(String numberBaseBall) {
        validation(numberBaseBall);
        convert(numberBaseBall);
    }

    public boolean contains(int number) {
        return baseBalls.contains(number);
    }

    public Integer get(int index) {
        return baseBalls.get(index);
    }

    private void validation(String numberBaseBall) {
        lengthCheck(numberBaseBall);
        numberCheck(numberBaseBall);
        overlapCheck(numberBaseBall);
    }

    private void lengthCheck(String numberBaseBall) {
        if (numberBaseBall.length() != 3) {
            throw new IllegalArgumentException(ValidationCode.LENGTH.getMessage());
        }
    }

    private void numberCheck(String numberBaseBall) {
        if (!numberBaseBall.matches("[0-9]+")) {
            throw new IllegalArgumentException(ValidationCode.NUMBER.getMessage());
        }
    }

    private void overlapCheck(String numberBaseBall) {
        Set<Character> set = new HashSet<>();

        for (char c : numberBaseBall.toCharArray()) {
            set.add(c);
        }

        if (set.size() != 3) {
            throw new IllegalArgumentException(ValidationCode.OVERLAP.getMessage());
        }
    }

    private void convert(String numberBaseBall) {
        for (char c : numberBaseBall.toCharArray()) {
            this.baseBalls.add(Integer.parseInt(String.valueOf(c)));
        }
    }
}
