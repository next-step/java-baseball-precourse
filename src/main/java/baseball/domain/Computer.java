package baseball.domain;

public class Computer {
    private BaseballNumber baseballNumber;

    public Computer() {
        this.baseballNumber = new BaseballNumber();
    }

    public BaseballNumber getBaseballNumber() {
        return this.baseballNumber;
    }
}
