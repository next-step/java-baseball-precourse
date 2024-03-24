package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;

public class Baseball {
    private final ArrayList<Integer> baseball;
    private static final String BASEBALL_NUMBER_PATTERN = "^[1-9]*$";
    public static final int VALID_BASEBALL_LENGTH = 3;

    public Baseball(String baseball) {
        isValidBaseball(baseball);
        this.baseball = convertStrToBaseball(baseball);
    }

    private void isValidBaseball(String baseball) {
        if (!baseball.matches(BASEBALL_NUMBER_PATTERN)) {
            throw new IllegalArgumentException("숫자는 1부터 9까지의 숫자여야 합니다.");
        }

        if (baseball.length() != VALID_BASEBALL_LENGTH) {
            throw new IllegalArgumentException("숫자는 3자리여야 합니다.");
        }

        if (hasDuplicateNumbers(baseball)) {
            throw new IllegalArgumentException("중복된 숫자가 존재해서는 안됩니다.");
        }
    }

    private boolean hasDuplicateNumbers(String baseball) {
        HashSet<Character> charSet = new HashSet<>();

        for (int i = 0; i < baseball.length(); i++) {
            charSet.add(baseball.charAt(i));
        }

        return charSet.size() != VALID_BASEBALL_LENGTH;
    }


    private ArrayList<Integer> convertStrToBaseball(String userInput) {
        ArrayList<Integer> baseball = new ArrayList<>();
        for (int i = 0; i < VALID_BASEBALL_LENGTH; i++) {
            baseball.add(Integer.parseInt(String.valueOf(userInput.charAt(i))));
        }
        return baseball;
    }

    public int getNumber(int index) {
        return baseball.get(index);
    }

    public ArrayList<Integer> getBaseball() {
        return baseball;
    }

    public boolean contains(int number) {
        return baseball.contains(number);
    }
}