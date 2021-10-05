package baseball.controller;

import baseball.model.GameResult;
import baseball.utils.RandomUtils;
import baseball.utils.ValidationUtils;
import baseball.view.BaseBallView;

public class BaseballGame {

	/**
	 * 컴퓨터와 사용자가 대결한다.
	 * 	- 컴퓨터는 랜덤한 숫자야구공을 생성한다.
	 * 	- 플레이어는 입력받은 숫자야구공으로 컴퓨터의 야구공을 맞춘다.
	 * 	- 결과를 출력한다.
	 * 	- 3스트라이크가 되기 전까지 종료하지 않는다.
	 */
	public void gameStart() {
		final Computer computer = new Computer(RandomUtils.generateNoDuplicateThreeBaseball());

		GameResult gameResult;

		do {
			final Player player = new Player(readInput());
			gameResult = player.play(computer);
			writeOutput(gameResult.toString());
		} while (gameResult.isNotFinished());
	}

	/**
	 * UI 로부터 문자열을 읽어들이며, ValidationUtils 를 통해 검증한다.
	 *
	 * @return 1-9 사이의 길이가 3인 문자열
	 */
	private String readInput() {
		String input;

		do {
			input = BaseBallView.requestInputNumber();
		} while (isInvalidInput(input));

		return input;
	}

	private boolean isInvalidInput(String input) {
		try {
			ValidationUtils.validateInput(input);
		} catch (IllegalArgumentException e) {
			BaseBallView.printResult(e.getMessage());
			return true;
		}

		return false;
	}

	private void writeOutput(String resultMsg) {
		BaseBallView.printResult(resultMsg);
	}

	/**
	 * 게임을 새로 시작할지에 대한 여부를 판단한다.
	 *
	 * @return 게임 재시작여부
	 */
	public boolean replay() {
		final ExitStatus exitStatus = ExitStatus.from(BaseBallView.replay());

		if (exitStatus.isReplay()) {
			return true;
		}
		if (exitStatus.isExit()) {
			return false;
		}

		throw new IllegalArgumentException("[ERROR] 게임을 재시작하거나 종료하기위해서는 1(재시작) 혹은 2(종료) 를 눌러주세요");
	}
}
