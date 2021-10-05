package baseball;

import baseball.domain.Computer;
import baseball.generator.NumbersGenerator;
import baseball.generator.RandomNumbersGenerator;
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
