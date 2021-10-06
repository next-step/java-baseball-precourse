package baseball.domain.utils;

import baseball.domain.exceptions.DuplicatedInputNumberException;
import baseball.domain.exceptions.InvalidInputNumberException;
import nextstep.utils.Randoms;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Numbers {

    public Integer[] getInputNumbersToArray(String input) throws DuplicatedInputNumberException, InvalidInputNumberException {
        Set<Integer> uniqueNumbers = new HashSet<>();

        if (!isValidate(input)) throw new InvalidInputNumberException(Messages.INPUT_ERROR.getMessage());

        Integer[] splittedInputNumbers = splitInputNumbers(input);

        if (hasDuplicatedNumber(uniqueNumbers, splittedInputNumbers))
            throw new DuplicatedInputNumberException(Messages.INPUT_ERROR.getMessage());

        return splittedInputNumbers;
    }

    private Integer[] splitInputNumbers(String input) {
        Integer[] orderedNumbersArr = new Integer[3];
        String[] s = input.split("");
        for (int i = 0; i < input.length(); i++) {
            orderedNumbersArr[i] = Integer.parseInt(s[i]);
        }
        return orderedNumbersArr;
    }

    private boolean hasDuplicatedNumber(Set<Integer> uniqueNumbers, Integer[] inputNumbers) {
        for (int i = 0; i < inputNumbers.length; i++) {
            uniqueNumbers.add(inputNumbers[i]);
        }
        return !(uniqueNumbers.size() == 3);
    }

    public Integer[] generate3RandomNumbers() {
        Integer[] orderedNumbersArr = new Integer[3];
        Set<Integer> uniqueNumbers = new HashSet<>();

        while (!(getCurrentSize(uniqueNumbers) == 3)) {

            int random = getRandom();
            int beforeSize = getCurrentSize(uniqueNumbers);

            uniqueNumbers.add(random);

            int afterSize = getCurrentSize(uniqueNumbers);

            boolean isDuplicated = checkDuplicatedNumber(beforeSize, afterSize);

            if (!isDuplicated) orderedNumbersArr[beforeSize] = random;
            if ((getCurrentSize(uniqueNumbers) == 3)) break;

        }
        return orderedNumbersArr;
    }

    private boolean isValidate(String input) {
        if (findMatches(Pattern.compile("^\\d{3}$"), input)) return true;

        return false;
    }

    private boolean findMatches(Pattern pattern, CharSequence input) {
        Matcher m = pattern.matcher(input);
        return m.find();
    }

    private int getRandom() {
        return Randoms.pickNumberInRange(1, 9);
    }

    private boolean checkDuplicatedNumber(int beforeSize, int afterSize) {
        return beforeSize == afterSize;
    }

    private int getCurrentSize(Set<Integer> uniqueNumbers) {
        return uniqueNumbers.size();
    }

}
