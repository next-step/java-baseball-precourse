package baseball.model;

import static baseball.utils.Constants.MAX_NUMBERS;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;

public class Computer extends Player {

    public Computer() {
        init();
    }

    private void init() {
        initNumbers();
    }

    private void initNumbers() {
        ArrayList<Integer> generatedNumbers = new ArrayList<>();
        while (generatedNumbers.size() < 3) {
            int generatedNumber = pickNumberInRange(0, 9);
            addNumber(generatedNumbers, generatedNumber);
        }

        this.setNumbers(generatedNumbers);
    }

    private void addNumber(ArrayList<Integer> generatedNumbers, int targetNumber) {
        if(!generatedNumbers.contains(targetNumber)) {
            generatedNumbers.add(targetNumber);
        }
    }
}
