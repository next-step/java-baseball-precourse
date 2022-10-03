package baseball.view;

import baseball.utils.Constants;
import baseball.utils.Validator;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGameView {
	Validator validator;
	public BaseballGameView() {
		validator = new Validator();
	}

	public void printMessage(String msg) {
		if (msg == null) return;
		System.out.print(msg);
	}

	public String getUserInputNum() {
		printMessage(Constants.INPUT_MESSAGE);
		String input = Console.readLine();
		if (validator.checkUserInputNum(input, Constants.RAND_NUM_SIZE, Constants.RAND_NUM_MIN, Constants.RAND_NUM_MAX)) {
			return input;
		}
		return null;
	}

	public String getUserInputEnd() {
		printMessage(Constants.END_MESSAGE + "\n");
		String input = Console.readLine();
		if (validator.checkUserInputNum(input, Constants.END_NUM_SIZE, Constants.END_NUM_MIN, Constants.END_NUM_MAX)) {
			return input;
		}
		return null;
	}
}
