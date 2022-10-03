package baseball.member;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int LEN_NUMBERS = 3;
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 9;

    private List<Integer> numbers = new ArrayList<>();

    public void choiceNumbers() {
        numbers.clear();
        while(numbers.size() < LEN_NUMBERS) {
            int num = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
            addNumber(num);
        }
    }

    private void addNumber(int num) {
        if(!numbers.contains(num)) {
            numbers.add(num);
        }
    }

    public Integer getNumber(int index) {
        return numbers.get(index);
    }

    public boolean containsNum(Integer num) {
        return numbers.contains(num);
    }
}