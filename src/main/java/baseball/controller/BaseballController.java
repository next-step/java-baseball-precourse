package baseball.controller;

import java.util.List;

import baseball.model.Baseball;
import baseball.view.View;

public class BaseballController {
	private final Baseball model = Baseball.getInstance();
	private final View view = View.getInstance();

	private BaseballController() {
	}

	private static final BaseballController instance = new BaseballController();

	public static BaseballController getInstance() {
		return instance;
	}

	public void execute() {
		do {
			start();
			process();
			end();
		} while (isRestart());
	}

	private void start() {
		model.initialize();
	}

	private void process() {
		List<Integer> input = requestInputNumbers();
	}

	private List<Integer> requestInputNumbers() {
		return view.inputThreeNumbers();
	}

	private void end() {

	}

	private boolean isRestart() {
		return false;
	}
}
