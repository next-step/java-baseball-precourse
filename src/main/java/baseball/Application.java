package baseball;

import baseball.functional.NumbersGenerator;
import baseball.functional.RandomNumbersGenerator;
import baseball.model.Computer;
import baseball.service.BaseBallGameService;

public class Application {
    private static final NumbersGenerator numberGenerator;
    private static final BaseBallGameService service;

    static {
        numberGenerator = new RandomNumbersGenerator();
        service = new BaseBallGameService(numberGenerator);
    }

    public static void main(String[] args) {
        service.startGame(Computer.create(numberGenerator));
    }
}
