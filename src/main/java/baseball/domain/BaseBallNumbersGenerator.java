package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;
import java.util.Set;

public class BaseBallNumbersGenerator {

    private final int NUMBER_LIMITATION = 3;

    public BaseBallNumbers createRandomBaseBallNumbers() {
        Set<Integer> generatedNumbers = new LinkedHashSet<>();
        while (generatedNumbers.size() < NUMBER_LIMITATION) {
            generatedNumbers.add(Randoms.pickNumberInRange(1, 9));
        }
        return new BaseBallNumbers(generatedNumbers);
    }

    public BaseBallNumbers createBaseBallNumbers(String numbers) {
        validThreeLength(numbers);
        validNumberFormat(numbers);
        return getThreeDigitsBaseBallNumbers(numbers);
    }

    private void validThreeLength(String numbers) {
        if (numbers.length() != NUMBER_LIMITATION) {
            throw new IllegalArgumentException();
        }
    }

    private void validNumberFormat(String numbers) {
        for (char number : numbers.toCharArray()) {
            if (!Character.isDigit(number)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private BaseBallNumbers getThreeDigitsBaseBallNumbers(String numbers) {
        Set<Integer> nonDuplicatesNumbers = new LinkedHashSet<>();
        for (char n : numbers.toCharArray()) {
            int number = Character.getNumericValue(n);
            validateOneToNine(number);
            nonDuplicatesNumbers.add(Character.getNumericValue(n));
        }
        validNonDuplicatesThreeDigits(nonDuplicatesNumbers);
        return new BaseBallNumbers(nonDuplicatesNumbers);
    }

    private void validateOneToNine(int number) {
        if (!(number >= 1 && number <= 9)) {
            throw new IllegalArgumentException();
        }
    }

    private void validNonDuplicatesThreeDigits(Set<Integer> nonDuplicatesNumbers) {
        if (nonDuplicatesNumbers.size() != NUMBER_LIMITATION) {
            throw new IllegalArgumentException();
        }
    }
}
