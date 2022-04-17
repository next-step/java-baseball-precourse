package baseball.domain.generator;

import baseball.domain.validator.NumbersValidator;
import java.util.ArrayList;
import java.util.List;

public class StringNumbersGenerator implements Generator {

    private final String numberString;

    public StringNumbersGenerator(String numberString) {
        this.numberString = numberString;
    }

    @Override
    public List<Integer> generateNumbers(int size) {
        return getUniqueNumberList(size);
    }

    private List<Integer> getUniqueNumberList(int size) {
        List<Integer> numbers = new ArrayList<>();
        if (NumbersValidator.isNumbersValidate(numberString, size)) {
            String[] numberStringSplit = numberString.split("");
            for (String str : numberStringSplit) {
                numbers.add(Integer.parseInt(str));
            }
        }
        return numbers;
    }

}
