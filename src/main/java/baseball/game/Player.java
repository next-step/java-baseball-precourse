package baseball.game;

import baseball.context.Numbers;
import baseball.io.Printer;
import baseball.io.Scanner;

public class Player {

    private final Printer printer;
    private final Scanner scanner;

    public Player(Printer printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    public Numbers present() {
        return printAndGetNumbers();
    }

    private Numbers printAndGetNumbers() {
        printer.print("숫자를 입력해주세요 : ");
        char[] rawNumbers = scanner.readLine().toCharArray();
        NumbersValidator.validate(rawNumbers);
        return Numbers.valueOf(rawNumbers);
    }
}
