package baseball.application;

import baseball.domain.Baseballs;

public class BaseballResult {
	private final int strikeNumber;
	private final int ballNumber;

	private BaseballResult(Baseballs computerBaseballs, Baseballs userBaseballs) {
		strikeNumber = computerBaseballs.countStrike(userBaseballs);
		ballNumber = computerBaseballs.countBall(userBaseballs);
	}

	public static BaseballResult of(Baseballs computerBaseballs, Baseballs userBaseballs){
		return new BaseballResult(computerBaseballs, userBaseballs);
	}

	public String getResult() {
		StringBuilder sb = new StringBuilder();

		if (strikeNumber == 0 && ballNumber == 0) {
			sb.append("낫싱");
		}
		if (ballNumber != 0) {
			sb.append(ballNumber).append("볼 ");
		}
		if (strikeNumber != 0) {
			sb.append(strikeNumber).append("스트라이크");
		}
		return sb.toString();
	}
}
