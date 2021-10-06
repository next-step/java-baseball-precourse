package baseball.domain.computer;

import baseball.domain.utils.Numbers;

public class Computer {

    private final Numbers numbers;

    public Computer() {
        this.numbers = new Numbers();
    }

    public Integer[] generator() {
        return numbers.generate3RandomNumbers();
    }

}