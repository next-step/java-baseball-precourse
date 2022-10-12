package baseball.vo;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomBaseballNumber {
    
    private List<Integer> randomNumbers;
    private int randomNumberSize = 3;

    public void initNumber() {
        randomNumbers = new ArrayList<>();
        for(int idx = 0; idx < randomNumberSize; idx++) {
            int randomNumber = generateRandomNumberNotOverlap();
            randomNumbers.add(randomNumber);
        }
    }

    private int generateRandomNumberNotOverlap() {
        int randomNumber;
        do {
            randomNumber = Randoms.pickNumberInRange(1, 9);
        } while(checkNotOverlapNumber(randomNumber));
        return randomNumber;
    }

    private boolean checkNotOverlapNumber(int randomNumber) {
        Boolean isExistSameNumber = null;
        for (int idx = 0; idx < randomNumbers.size(); idx++) {
            isExistSameNumber = compareSameNumber(randomNumbers.get(idx), randomNumber);
        }

        if (isExistSameNumber != null) {
            return isExistSameNumber;
        }
        return false;
    }

    private Boolean compareSameNumber(Integer inputRandomNumber, int randomNumber) {
        if(inputRandomNumber == randomNumber) {
            return true;
        }
        return null;
    }

    public String getResultRandomNumber() {
        StringBuilder randomNumber = new StringBuilder();
        for (Integer number : randomNumbers) {
            randomNumber.append(number);
        }
        return randomNumber.toString();
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }

    public boolean checkContainNumber(int targetNumber) {
        return randomNumbers.contains(targetNumber);
    }

    public boolean checkSameLocationNumber(int targetNumber, int idx) {
        return randomNumbers.get(idx) == targetNumber;
    }
}
