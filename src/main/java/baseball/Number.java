package baseball;

import java.util.HashSet;
import java.util.Set;

public class Number {
    private final static int NUMBER_LENGTH = 3;
    private final String value;

    public Number(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (value.length() != NUMBER_LENGTH) throw new IllegalArgumentException("[ERROR] 숫자의 길이가 올바르지 않습니다");

        Set<Character> numbers = new HashSet<>();
        for (char number : value.toCharArray()) numbers.add(number);
        if (numbers.size() != NUMBER_LENGTH) throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다");
    }

    public String getValue() {
        return this.value;
    }
}
