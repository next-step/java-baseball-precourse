package baseball;

import java.util.ArrayList;
import java.util.List;

/**
 * 숫자야구게임의 숫자.
 */
public class BaseballNumbers {
    private final List<Integer> numbers;

    public BaseballNumbers(String numberStr) {
        this.numbers = new ArrayList<>();
        for (String s : numberStr.split("")) {
            this.numbers.add(toInt(s));
        }
    }

    public BaseballNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    /**
     * 베이스볼게임 시도를 한 문자열을 숫자 변경하여 리턴합니다.
     *
     * @throws IllegalArgumentException 숫자가 아닌 경우.
     * @param s 유저가 입력한 문자열
     */
    private int toInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch(NumberFormatException ne) {
            throw new IllegalArgumentException(ne);
        }
    }

    private Score.ScoreEnum match(Integer number, int idx) {
        if (this.numbers.get(idx).equals(number)) {
            return Score.ScoreEnum.STRIKE;
        }

        if (this.numbers.contains(number)) {
            return Score.ScoreEnum.BALL;
        }

        return Score.ScoreEnum.NOTHING;
    }

    void validateAttemptNumber(final BaseballNumbers baseballNumbers) {
        if (baseballNumbers.numbers.size() != this.numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * otherBaseballNumbers와 this를 비교하여 Score를 리턴합니다.
     */
    public Score matchScore(final BaseballNumbers otherBaseballNumbers) {
        validateAttemptNumber(otherBaseballNumbers);

        final List<Score.ScoreEnum> scoreEnums = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            scoreEnums.add(match(otherBaseballNumbers.numbers.get(i), i));
        }

        return new Score(scoreEnums, numbers.size());
    }

    @Override
    public String toString() {
        return "BaseballNumbers{" +
                "numbers=" + numbers +
                '}';
    }
}
