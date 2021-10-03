package baseball;

import java.util.List;

import baseball.domain.Computer;
import baseball.domain.User;

public class Application {

	static Computer computer = new Computer();
	static User user = new User();

	public static void main(String[] args) {
		List randomValue = computer.getClearRandomValue();
		List userInput = null;
		while (!computer.isGameClear()) {
			userInput = user.getClearInputReadLine();

			computer.checkStrike(randomValue, userInput);
			computer.checkBall(randomValue, userInput);
			computer.checkNothing();
			computer.makeHint();
		}
	}
}
