package baseball.controller;

import baseball.model.Baseball;

public class BaseballController {
	private final Baseball model = Baseball.getInstance();

	private BaseballController() {
	}

	private static final BaseballController instance = new BaseballController();

	public static BaseballController getInstance() {
		return instance;
	}

	public void execute() {
		start();
	}

	private void start() {
		model.initialize();
	}
}
