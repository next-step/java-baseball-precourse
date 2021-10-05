package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private static final String SPLIT_REGEX = "";
    private static final int MAX_LENGTH = 3;

    private final List<Number> numbers = new ArrayList<>();

    public Numbers(String value) {
        checkSize(value);
        for (String string : value.split(SPLIT_REGEX)) {
            final Number number = new Number(string);
            checkDuplicate(number);
            this.numbers.add(number);
        }
    }

    private void checkSize(String value) {
        if (value.length() != MAX_LENGTH) {
            throw new RuntimeException("[ERROR] 3자리 숫자만 입력가능합니다.");
        }
    }

    private void checkDuplicate(Number number) {
        if(this.numbers.contains(number)) {
            throw new RuntimeException("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
        }
    }

    public List<Number> getNumbers() {
        return this.numbers;
    }
}
