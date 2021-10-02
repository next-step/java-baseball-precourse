package baseball.domain;

import nextstep.utils.Randoms;

import java.util.*;

public class BaseballNumber {

    private static final int BALL_MIN_NUMBER = 1;
    private static final int BALL_MAX_NUMBER = 9;
    private static final int BASEBALL_SIZE = 3;

    private final List<Integer> ballNumbers;

    public BaseballNumber(String numberString) {
        validateOnlyNumber(numberString);
        validateSize(numberString);
        validateDuplicate(numberString);
        this.ballNumbers = toNumbers(numberString);
    }

    public static BaseballNumber generate() {
        Set<String> numbersSet = new LinkedHashSet<>();
        while (numbersSet.size() != BASEBALL_SIZE) {
            numbersSet.add(Randoms.pickNumberInRange(BALL_MIN_NUMBER, BALL_MAX_NUMBER) + "");
        }
        return new BaseballNumber(String.join("", numbersSet));
    }

    private void validateOnlyNumber(String numberString) {
        try {
            Integer.parseInt(numberString);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }

    private void validateSize(String numberString) {
        if (numberString.length() != BASEBALL_SIZE) {
            throw new IllegalArgumentException(String.format("[ERROR] %d자리의 숫자를 입력해주세요.", BASEBALL_SIZE));
        }
    }

    private void validateDuplicate(String numberString) {
        Set<String> numbersSet = new HashSet(Arrays.asList(numberString.split("")));
        if (numbersSet.size() != BASEBALL_SIZE) {
            throw new IllegalArgumentException("[ERROR] 중복 없는 숫자를 입력해주세요.");
        }
    }

    private List<Integer> toNumbers(String numberString) {
        List<Integer> numbers = new ArrayList<>();
        for (String str: numberString.split("")) {
            numbers.add(Integer.parseInt(str));
        }
        return numbers;
    }

    public HashSet<Integer> toHashSet() {
        return new HashSet<>(ballNumbers);
    }

    @Override
    public String toString() {
        return "BaseBall{" +
                "ballNumbers=" + ballNumbers +
                '}';
    }
}
