package baseball.input.bean;

import baseball.input.PlayerNumberValidator;
import baseball.result.Converter;

import java.util.List;

public class Player {
    private List<Integer> numbers;
    private Converter converter = new Converter();
    private PlayerNumberValidator playerNumberValidator;

    public Player() {
        this.playerNumberValidator = new PlayerNumberValidator();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = this.converter.stringToIntegerList(numbers);
    }
}
