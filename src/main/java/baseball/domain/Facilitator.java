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
            inputNumbers(numbers, num);
        }
        return numbers;
    }

    public void inputNumbers(List<Integer> numbers, int num) {
        if(!numbers.contains(num)) {
            numbers.add(num);
        }
    }

    public List<Integer> splitNumbers(String numbersStr) {
        validation(numbersStr);
        List<Integer> numbers = new ArrayList<>();
        for(String numStr : numbersStr.split("")) {
            numbers.add(Integer.valueOf(numStr));
        }
        return numbers;
    }

    private void validation(String numbersStr) {
        if(!numbersStr.matches("[+-]?\\d*(\\.\\d+)?") || numbersStr.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isContinueGame(int select) {
        boolean result = false;
        if(select == START_GAME_NUM) {
            result = true;
        }
        return result;
    }
}