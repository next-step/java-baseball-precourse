package baseball;

import baseball.controller.BaseBallGameController;
import baseball.generator.RandomNumbersGenerator;

public class Application {
    public static void main(String[] args) {
		BaseBallGameController.create(new RandomNumbersGenerator())
			.start();
	}
}
