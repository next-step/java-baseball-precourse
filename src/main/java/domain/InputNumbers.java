package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static domain.constant.Constant.*;

public class InputNumbers {
    private final List<Integer> numbers;

    public InputNumbers(String input) {
        List<Integer> inputNumbers = getDistinctNumbers(input);
        validateInputNumbers(inputNumbers);
        this.numbers = inputNumbers;
    }

    private List<Integer> getDistinctNumbers(String input) {
        try {
            return Arrays.stream(input.split(""))
                    .map(Integer::new)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBERS_FORMAT_VALIDATION_EXCEPTION);
        }
    }

    private void validateInputNumbers(List<Integer> inputNumbers) {
        validateInputSize(inputNumbers);
        validateInputValue(inputNumbers);
        validateDuplicateValue(inputNumbers);
    }

    private void validateInputSize(List<Integer> inputNumbers) {
        if(inputNumbers.size() != 3)
            throw new IllegalArgumentException(NUMBERS_SIZE_VALIDATION_EXCEPTION);
    }

    private void validateInputValue(List<Integer> inputNumbers) {
        for(int number : inputNumbers) {
            if (!(number >= MINUMUM_NUMBER && number <= MAXIMUM_NUMBER))
                throw new IllegalArgumentException(NUMBERS_VALUE_VALIDATION_EXCEPTION);
        }
    }

    private void validateDuplicateValue(List<Integer> inputNumbers) {
        int duplicateRemovedResultSize =
                inputNumbers.stream().distinct().collect(Collectors.toList()).size();
        if(inputNumbers.size() != duplicateRemovedResultSize)
            throw new IllegalArgumentException(NUMBERS_DUPLICATE_VALIDATION_EXCEPTION);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
