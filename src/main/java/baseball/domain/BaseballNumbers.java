package baseball.domain;

import baseball.domain.exceptions.BaseballIllegalArgumentException;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.domain.BaseballNumber.*;
import static baseball.domain.ConsoleMessage.EXCEPTION_DUPLICATED_BASEBALL_NUMBERS;
import static baseball.domain.ConsoleMessage.EXCEPTION_INVALID_BASEBALL_NUMBERS;

public class BaseballNumbers {

    public static final int SIZE = 3;
    private static final String REGEX_BASEBALL_NUMBERS = String.format("[%d-%d]{%d}", MIN_VALUE, MAX_VALUE, SIZE);
    private static final int BASEBALL_NUMBER_SIZE = 3;

    private final BaseballNumber[] baseballNumbers;

    public BaseballNumbers(final int[] value) {
        this.baseballNumbers = new BaseballNumber[BASEBALL_NUMBER_SIZE];
        for (int index = 0; index < value.length; index++) {
            this.baseballNumbers[index] = new BaseballNumber(value[index]);
        }
    }

    public static BaseballNumbers of(final String value) {
        verifyValue(value);
        int[] numbers = new int[SIZE];
        for (int index = 0; index < value.length(); index++) {
            numbers[index] = Character.getNumericValue(value.charAt(index));
        }
        return new BaseballNumbers(numbers);
    }

    public static BaseballNumbers generateRandomNumbers() {
        List<Integer> numbers = pickUniqueNumberInRange();
        return new BaseballNumbers(toIntArray(numbers));
    }

    public void generateRandomNumbersOfRestart() {
        List<Integer> numbers = pickUniqueNumberInRange();
        for (int index = 0; index < numbers.size(); index++) {
            this.baseballNumbers[index] = new BaseballNumber(numbers.get(index));
        }
    }

    private static List<Integer> pickUniqueNumberInRange() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            numbers.add(pickUniqueNumberInRange(numbers));
        }
        return numbers;
    }

    private static int pickUniqueNumberInRange(final List<Integer> numbers) {
        int pickNumber;
        do {
            pickNumber = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
        } while (numbers.contains(pickNumber));
        return pickNumber;
    }

    public BaseballScore calculateScore(final BaseballNumbers baseballNumbersOfPlayer) {
        int strike = 0;
        int ball = 0;
        for (int position = 0; position < SIZE; position++) {
            if (isStrike(baseballNumbersOfPlayer, position)) strike++;
            if (isBall(baseballNumbersOfPlayer, position)) ball++;
        }
        return new BaseballScore(strike, ball);
    }

    private boolean isStrike(final BaseballNumbers baseballNumbersOfPlayer, final int position) {
        return this.baseballNumbers[position].equals(baseballNumbersOfPlayer.baseballNumbers[position]);
    }

    private boolean isBall(final BaseballNumbers baseballNumbersOfPlayer, final int position) {
        for (int i = 0; i < SIZE; i++) {
            if (i == position) continue;
            if (baseballNumbersOfPlayer.baseballNumbers[position].equals(this.baseballNumbers[i])) return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public static int[] toIntArray(final List<Integer> integers) {
        int[] intArray = new int[integers.size()];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = integers.get(i);
        }
        return intArray;
    }

    private static void verifyValue(final String value) {
        isValidNumberRange(value);
        isUniqueNumbers(value);
    }

    private static void isUniqueNumbers(final String value) {
        Set<Character> uniqueValues = toSet(value.toCharArray());
        if (uniqueValues.size() != SIZE) {
            throw new BaseballIllegalArgumentException(EXCEPTION_DUPLICATED_BASEBALL_NUMBERS);
        }
    }

    private static Set<Character> toSet(final char[] chars) {
        Set<Character> uniqueValues = new HashSet<>();
        for (Character c : chars) {
            uniqueValues.add(c);
        }
        return uniqueValues;
    }

    private static void isValidNumberRange(final String value) {
        if (!value.matches(REGEX_BASEBALL_NUMBERS)) {
            throw new BaseballIllegalArgumentException(EXCEPTION_INVALID_BASEBALL_NUMBERS);
        }
    }

    public BaseballNumber[] getBaseballNumbers() {
        return baseballNumbers;
    }
}
