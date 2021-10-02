package baseball;

import java.util.List;

import baseball.domain.Computer;
import baseball.domain.User;

public class Application {

	public static void main(String[] args) {
		Computer computer = new Computer();
		User user = new User();
		List randomValue = computer.getClearRandomValue();
		List userInput = null;

		while (!computer.isGameClear()) {
			userInput = user.getClearInputReadLine();

			computer.checkStrike(randomValue, userInput);
			computer.checkBall(randomValue, userInput);
			computer.checkNothing();

			String hint = computer.makeHint();
			System.out.println(hint);
		}

	}

}
