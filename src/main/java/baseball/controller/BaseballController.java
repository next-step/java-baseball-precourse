package baseball.controller;

public class BaseballController {

	private BaseballController() {
	}

	private static final BaseballController instance = new BaseballController();

	public static BaseballController getInstance() {
		return instance;
	}

	public void execute() {

	}
}
