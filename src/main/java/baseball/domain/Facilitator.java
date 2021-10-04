package baseball.domain;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Facilitator {
    private static final int START_GAME_NUM = 1;

    public List<Integer> numbersGenerator() {
        List<Integer> numbers = new ArrayList<>();
        while(numbers.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            if(!numbers.contains(num)) {
                numbers.add(num);
            }
        }
        return numbers;
    }

    public List<Integer> splitNumbers(String numbersStr) throws NumberFormatException, IndexOutOfBoundsException {
        List<Integer> numbers = new ArrayList<>();
        for(String numStr : numbersStr.split("")) {
            numbers.add(Integer.valueOf(numStr));
        }
        if(numbers.size() > 3) {
            throw new IndexOutOfBoundsException();
        }
        return numbers;
    }

    public boolean isContinueGame(int select) {
        boolean result = false;
        if(select == START_GAME_NUM) {
            result = true;
        }
        return result;
    }
}