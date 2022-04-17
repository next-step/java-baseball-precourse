package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final static int maxLength = 3;
    private List<Integer> numbers = new ArrayList<>();

    public User(String numbers) {
        createNumbers(numbers);
    }

    private void createNumbers(String _numbers) {
        this.numbers = splitNumbers(_numbers);
    }

    private List<Integer> splitNumbers(String numbers) {
        isNumeric(numbers);
        List<Integer> result = new ArrayList<>(maxLength);
        String[] split = numbers.split("");
        checkNumbersValidation(split);
        for (int i = 0; i < split.length; i++) {
            result.add(Integer.parseInt(split[i]));
        }
        return result;
    }

    private void checkNumbersValidation(String[] split) {
        isLongerThanMaxLength(split);
        checkAllNumbersSame(split);
        for (int i = 0; i < split.length; i++) {
            isNumberInRange(Integer.parseInt(split[i]));
        }
    }

    private void checkAllNumbersSame(String[] split) {
        if ((Integer.parseInt(split[0]) == Integer.parseInt(split[1])) &&
                (Integer.parseInt(split[0]) == Integer.parseInt(split[2]))) {
            throw new IllegalArgumentException("게임 종료");
        }
    }

    private void isNumberInRange(int parseInt) {
        if (parseInt < 0 || parseInt > 9) {
            throw new IllegalArgumentException("게임 종료");
        }
    }

    private void isLongerThanMaxLength(String[] split) {
        if (split.length > maxLength) {
            throw new IllegalArgumentException("게임 종료");
        }
    }

    private void isNumeric(String numbers) {
        if (numbers == null || numbers.equals("") || numbers.equals(" ")) {
            throw new IllegalArgumentException("게임 종료");
        }
    }


    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void checkNumber(int number) {
        int index = this.numbers.indexOf(number);
        if (this.numbers.contains(number) && index != -1) {
            this.numbers.set(index, -1);
        }
    }
}
