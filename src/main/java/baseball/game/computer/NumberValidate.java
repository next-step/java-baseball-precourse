package baseball.game.computer;

import java.util.ArrayList;
import java.util.Collections;

public class NumberValidate {

    private int randomNumber;

    NumberValidate(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public ArrayList<Boolean> getValidateResults() {
        return validateOverlap();
    }

    private ArrayList<Boolean> validateOverlap() {
        ArrayList<Integer> intList = arrayRandomNumber(this.randomNumber);
        ArrayList<Boolean> booleanCnt = new ArrayList<>();
        for(int i = 0; i < intList.size(); i++) {
            booleanCnt.add(validateArrayOverlap(intList, intList.get(i)));
        }
        return booleanCnt;
    }

    private boolean validateArrayOverlap(ArrayList<Integer> intList, int compareTarget) {
        int overlapFrequencyCnt = Collections.frequency(intList, compareTarget);
        int zeroFrequencyCnt = Collections.frequency(intList, 0);

        if(overlapFrequencyCnt > 1 || zeroFrequencyCnt > 0) {
            return false;
        }
        return true;
    }

    private ArrayList<Integer> arrayRandomNumber(int randomNumber) {
        ArrayList<Integer> intList = new ArrayList<>();
        while(randomNumber > 0) {
            intList.add(randomNumber %10);
            randomNumber /= 10;
        }
        return intList;
    }
}
