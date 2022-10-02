package baseball.model;

import static baseball.utils.Constants.MAX_NUMBERS;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> numbers;

    public Player(){ }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public void setNumbers(List<Integer> inputNumbers) {
        this.numbers = inputNumbers;
    }
}
