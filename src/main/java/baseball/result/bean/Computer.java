package baseball.result.bean;

import baseball.result.Converter;

import java.util.List;

public class Computer {
    private Converter converter = new Converter();
    private List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = this.converter.stringToIntegerList(numbers);
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
