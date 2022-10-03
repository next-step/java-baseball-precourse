package baseball.domain;

import baseball.util.Converter;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.service.BaseballReferee.END_INCLUSIVE;
import static baseball.service.BaseballReferee.NUMBER_SIZE;
import static baseball.service.BaseballReferee.START_INCLUSIVE;

public class BaseballPlayer {

    private final List<Integer> numbers;

    private BaseballPlayer(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static BaseballPlayer computer() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < NUMBER_SIZE) {
            numbers.add(Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
        }
        return new BaseballPlayer(new ArrayList<>(numbers));
    }

    public static BaseballPlayer user(String command) {
        return new BaseballPlayer(Converter.stringToList(command));
    }

    public BaseballResult compare(BaseballPlayer player2) {
        List<Integer> otherNumbers = player2.getNumbers();
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < this.numbers.size() ; i++) {
            boolean isContains = this.numbers.contains(otherNumbers.get(i));
            boolean isEquals = this.numbers.get(i).equals(otherNumbers.get(i));
            strikeCount = isEqualsAddCount(strikeCount, isEquals);
            ballCount = isContainsAndNotEqualsAddCount(ballCount, isContains, isEquals);
        }
        return new BaseballResult(getHint(strikeCount, ballCount), strikeCount == NUMBER_SIZE);
    }

    private String getHint(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }
        else if (strike == 0) {
            return String.format("%d볼", ball);
        }
        else if (ball == 0) {
            return String.format("%d스트라이크", strike);
        }
        return String.format("%d볼 %d스트라이크", ball, strike);
    }

    private int isEqualsAddCount(int count, boolean isEquals) {
        if (isEquals) {
           return count + 1;
        }
        return count;
    }

    private int isContainsAndNotEqualsAddCount(int count, boolean isContains, boolean isEquals) {
        if (isContains && !isEquals) {
           return count + 1;
        }
        return count;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
