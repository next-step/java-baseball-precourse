package baseball.domain.generator;

import baseball.domain.GameRule;
import baseball.domain.validator.NumbersValidator;
import java.util.ArrayList;
import java.util.List;

public class StringNumbersGenerator implements Generator {

    private final String numberString;
    private final NumbersValidator numbersValidator;

    public StringNumbersGenerator(String numberString, GameRule gameRule) {
        this.numberString = numberString;
        this.numbersValidator = new NumbersValidator(gameRule);
    }

    @Override
    public List<Integer> generateNumbers() {
        return getUniqueNumberList();
    }

    private List<Integer> getUniqueNumberList() {
        List<Integer> numbers = new ArrayList<>();
        if (numbersValidator.isNumbersValidate(numberString)) {
            String[] numberStringSplit = numberString.split("");
            for (String str : numberStringSplit) {
                numbers.add(Integer.parseInt(str));
            }
        }
        return numbers;
    }

}
