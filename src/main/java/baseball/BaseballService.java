package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class BaseballService {

    public static final int MAX_SIZE = 3;
    public static final int MIN_DIGIT = 1;
    public static final int MAX_DIGIT = 9;

    public void validateNumber(String number) {
        if (!isThreeDigitNumberWithoutZero(number)) {
            throw new IllegalArgumentException();
        }
        if (hasDuplicatedDigit(number)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasDuplicatedDigit(String number) {
        if (number.charAt(0) == number.charAt(1) || number.charAt(0) == number.charAt(2)
                || number.charAt(1) == number.charAt(2)) {
            return true;
        }
        return false;
    }

    private boolean isThreeDigitNumberWithoutZero(String number) {
        String pattern = "[1-9][1-9][1-9]";
        return Pattern.matches(pattern, number);
    }

    public String generateRandomThreeDigitNumber() {
        List<Integer> number = new ArrayList<>();
        while (number.size() < MAX_SIZE) {
            number.add(getDigitNotIn(number));
        }
        return convertIntegerListToString(number);
    }

    private String convertIntegerListToString(List<Integer> list) {
        String result = "";
        for (Integer item : list) {
            result += item;
        }
        return result;
    }

    private int getDigitNotIn(List<Integer> number) {
        int digit = Randoms.pickNumberInRange(MIN_DIGIT, MAX_DIGIT);
        while (number.contains(digit)) {
            digit = Randoms.pickNumberInRange(MIN_DIGIT, MAX_DIGIT);
        }
        return digit;
    }

    public Score countScore(String answer, String input) {
        Score score = new Score();
        for (int position = 0; position < MAX_SIZE; position++) {
            score.countBall(answer, input, position);
            score.countStrike(answer, input, position);
        }
        return score;
    }

    public boolean isGameEnded(Score score) {
        if (score.getStrike() == MAX_SIZE) {
            return true;
        }
        return false;
    }
}
