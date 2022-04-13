package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;


public class ComputerRandomNumber {

    List<Integer> inputs = new ArrayList<>();

    public int getRandomNumbers() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public void checkDuplicateNumber(Integer number) {
        boolean isDuplicated = inputs.contains(number);
        if (!isDuplicated) {
            inputs.add(number);
        }
    }

    public void throwAutoThreeTimes() {
        while (inputs.size() != 3) {
            int number = getRandomNumbers();
            checkDuplicateNumber(number);
        }
    }

}
