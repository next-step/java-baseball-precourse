package baseball.game;

import baseball.context.Numbers;
import baseball.context.Result;
import baseball.io.Printer;

public class Computer {

    private final Printer resultPrinter;

    public Computer(Printer resultPrinter) {
        this.resultPrinter = resultPrinter;
    }

    private Numbers numbers;
    private Result result;

    public void generateNumber() {
        if (this.numbers == null) {
            this.numbers = new Numbers();
        }
        this.numbers.random();
    }

    public void match(Numbers numbers) {
        this.result = new Result(0, 0);
        this.result.add(this.numbers.firstResult(numbers));
        this.result.add(this.numbers.secondResult(numbers));
        this.result.add(this.numbers.thirdResult(numbers));
    }

    public void printResult() {
        this.result.print(this.resultPrinter);
    }

    public boolean lose() {
        return this.result.isPerfect();
    }
}
