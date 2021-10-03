package baseball;

public class BaseballGame {

	Validator validator;
	BaseballUi baseballUi;
	Balls computerBalls;

	public BaseballGame() {
		this.validator = new Validator();
		this.baseballUi = new BaseballUi();
	}

	private void setNewBalls() {
		this.computerBalls = new Balls(NumberGenerator.createNumber());
		System.out.println(this.computerBalls);
	}

	private boolean isValid(String inputNumber) {
		try {
			validator.isValid(inputNumber);
			return true;
		} catch (Exception e) {
			baseballUi.printExceptionMessage(e);
			return false;
		}
	}

	public void start() {

		setNewBalls();

		while (true) {

			String inputNumber = baseballUi.askForNumber();
			if (!isValid(inputNumber)) {
				continue;
			}

			Balls userBalls = new Balls(inputNumber);
			GameResult result = computerBalls.play(userBalls);
			baseballUi.printGameResult(result);

			if (result.isComplete()) {
				if (!baseballUi.askForRestart()) {
					break;
				}
				setNewBalls();
			}
		}
		baseballUi.printEnd();
	}

}
