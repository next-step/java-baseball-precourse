package baseball.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final static int maxLength = 3;
    private List<Integer> numbers = new ArrayList<>();

    public Computer() {
        createRandomNumbers();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    private void createRandomNumbers(){
        int[] numbers = new int[]{1,2,3,4,5,6,7,8,9};
        int initRandomIndex = pickNumberInRange(0, 6);
        for(int i=0; i<maxLength; i++){
            this.numbers.add(numbers[initRandomIndex + i]);
        }
    }
}
