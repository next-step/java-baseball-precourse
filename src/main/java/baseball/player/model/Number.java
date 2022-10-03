package baseball.player.model;

import baseball.game.model.GameNumber;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Number extends GameNumber {
    private Pattern formatPattern = Pattern.compile("^[1-9]{3}$");

    public Set<Integer> parsingNumber(String number) {
//        validateNumber(number);
        Set<Integer> numbers = new HashSet<>();

        for (int i = 0; i < number.length(); i++) {
            numbers.add(Integer.parseInt(String.valueOf(number.charAt(i))));
        }
        return numbers;
    }

    public void validateNumber(String number) {
        validateFormat(number);
        validateDuplicatedNumber(number);
    }

    private void validateFormat(String number) {
        Matcher matcher = formatPattern.matcher(number);
        boolean isMatched = matcher.matches();
        if (!isMatched) {
            throw new IllegalArgumentException("1과 9사이의 숫자로 이루어진 3자리 정수를 입력해주세요.");
        }
    }

    private void validateDuplicatedNumber(String number) {
        Set<Integer> numbers = new HashSet<>();

        for (int i = 0; i < number.length(); i++) {
            numbers.add(Integer.parseInt(String.valueOf(number.charAt(i))));
        }

        if (numbers.size() != number.length()) {
            throw new IllegalArgumentException("1과 9사이의 서로 다른 숫자를 입력해주세요.");
        }
    }

}
