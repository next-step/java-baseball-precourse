package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static domain.constant.Constant.*;

public class GeneratedNumbers {
    private final List<Integer> numbers;
    public GeneratedNumbers() {
        this.numbers = getRandomNumbers();
    }

    private List<Integer> getRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while(randomNumbers.size() < MAXIMUM_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MINUMUM_NUMBER, MAXIMUM_NUMBER);
            validateRandomNumber(randomNumber);
            if(!randomNumbers.contains(randomNumber))
                randomNumbers.add(randomNumber);
        }
        return randomNumbers;
    }

    private void validateRandomNumber(int randomNumber) {
        if (!(randomNumber >= MINUMUM_NUMBER && randomNumber <= MAXIMUM_NUMBER))
            throw new IllegalArgumentException(NUMBERS_VALUE_VALIDATION_EXCEPTION);
    }

    public int getIndex(int number) {
        return numbers.indexOf(number);
    }

    public boolean find(int number) {
        return numbers.contains(number);
    }
}
