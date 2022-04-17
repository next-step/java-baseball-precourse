package baseball.domain;

import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class BaseballGameRule {

    public BaseballGameResult judge(List<Integer> numbers, List<Integer> compareNumbers) {
        BaseballGameResult result = new BaseballGameResult();
        numbers.forEach((num) -> {
            int index = numbers.indexOf(num);
            checkBaseballCount(num, index, compareNumbers, result);
        });
        return result;
    }

    private void checkBaseballCount(int number, int index
            , List<Integer> compareNumbers
            , BaseballGameResult result) {
        int position = compareNumbers.indexOf(number);
        if(position > -1 && position != index) result.incrementBall();
        if(position > -1 && position == index) result.incrementStrike();
    }
}
