package baseball.view;

import java.io.PrintStream;

import baseball.model.BallCount;

public class OutputView {

	private static final PrintStream OUTPUT = System.out;

	public void printInputNumber() {
		OUTPUT.print("숫자를 입력해주세요 : ");
	}

	public void printGameResult(BallCount ballCount) {
		String s = "";
		if (ballCount.countStrike() > 0) {
			s += ballCount.countStrike() + "스트라이크 ";
		}
		if (ballCount.countBall() > 0) {
			s += ballCount.countBall() + "볼";
		}
		if (ballCount.isNothing()) {
			s = "낫싱";
		}

		OUTPUT.println(s);
	}
}
