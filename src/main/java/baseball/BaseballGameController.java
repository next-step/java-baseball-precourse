package baseball;

public class BaseballGameController {
	public void run() {
		do {
			BaseballGame baseballGame = new BaseballGame();
			baseballGame.start();
			Output.printRestartOrStopMessage();
		} while (isRestart());
	}

	public boolean isRestart() {
		String selector = Input.readPlayerInput();
		if (!(selector.equals("1") || selector.equals("2"))) {
			Output.printExceptionMessage("재시작 여부를 잘 못 입력 하셨습니다.");
			isRestart();
		}
		if (selector.equals("2")) {
			return false;
		}
		return true;
	}
}
