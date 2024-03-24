package model;

import exception.GameException;

import java.util.HashSet;
import java.util.Set;

public class BaseballNumber {

    // MUST BE UNDER 10
    public static final int VALID_LENGTH = 3;

    private final String value;

    private BaseballNumber(String value) {
        this.value = value;
        validate();
    }

    private void validate() {
        if (value.length() != VALID_LENGTH) {
            throw new GameException("숫자의 길이가 올바르지 않습니다.");
        }

        if (sameDigitExists()) {
            throw new GameException("중복된 숫자가 존재합니다.");
        }

        if (zeroExists()) {
            throw new GameException("0이 존재합니다.");
        }
    }

    private boolean sameDigitExists() {
        Set<Character> s = new HashSet<>();
        for (int i = 0; i < value.length(); i++) {
            s.add(value.charAt(i));
        }
        return s.size() != value.length();
    }

    private boolean zeroExists() {
        return value.contains("0");
    }

    public static BaseballNumber of(int num) {
        return new BaseballNumber(String.valueOf(num));
    }

    public int get(int index) {
        return Character.getNumericValue(value.charAt(index));
    }

    public boolean contains(int num) {
        return value.contains(String.valueOf(num));
    }
}
