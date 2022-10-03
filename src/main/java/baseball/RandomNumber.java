package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {

    private final Rule rule;

    public RandomNumber(Rule rule) {
        this.rule = rule;
    }

    // 규칙에 맞는 수 생성
    public List<Integer> getNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (!rule.validateNumbers(numbers)) {
            numbers.clear();
            for (int i = 0; i < rule.NUMBER_OF_DIGITS; i++) {
                numbers.add(Randoms.pickNumberInRange(rule.MIN_BASEBALL_NUMBER, rule.MAX_BASEBALL_NUMBER));
            }
        }
        return numbers;
    }


}
