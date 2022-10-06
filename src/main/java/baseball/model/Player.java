package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> numbers;

    public Player(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Player() {

    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = changeStringToIntegerList(numbers);
    }

    public List<Integer> changeStringToIntegerList(String numStr) {
        List<Integer> tempNumbers = new ArrayList<>();
        int idx = 0;

        while (idx < numStr.length()) {
            tempNumbers.add(Integer.valueOf(numStr.substring(idx, idx + 1)));
            idx++;
        }

        return tempNumbers;
    }
}
