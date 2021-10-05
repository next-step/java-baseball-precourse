package baseball.controller;

import java.util.List;

import baseball.model.Baseball;
import baseball.model.result.Result;
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
		Result result = null;

		while (isRetry(result)) {
			List<Integer> input = requestInputNumbers();
			result = matchNumbers(input);

			view.outputResult(result.getMessage());
		}
	}

	private List<Integer> requestInputNumbers() {
		return view.inputThreeNumbers();
	}

	private Result matchNumbers(List<Integer> inputNumbers) {
		return model.checkIfTheAnswerIsCorrect(inputNumbers);
	}

	private boolean isRetry(Result result) {
		return result == null || !result.isSuccessful();
	}

	private void end() {
		view.outputEnd();
	}

	private boolean isRestart() {
		int input = view.inputRestartOrEndNumber();
		return input == 1;
	}
}
