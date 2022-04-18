package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomBaseballGenerator implements BaseballGenerator {

    private List<Integer> computerNumber;

    @Override
    public List<Integer> Generate() {
        computerNumber = new ArrayList<>();

        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            checkAndAdd(randomNumber);
        }

        return computerNumber;
    }

    public void checkAndAdd(int randomNumber) {
        if (!computerNumber.contains(randomNumber)) {
            computerNumber.add(randomNumber);
        }
    }
}
