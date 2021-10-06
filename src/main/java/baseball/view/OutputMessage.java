package baseball.view;

import baseball.domain.Numbers;

public class OutputMessage {

	public static void printHint(int strike, int ball) {
		StringBuilder result = new StringBuilder();
		buildStrikeResult(strike, result);

		if (strike < Numbers.RANGE_SIZE) {
			buildBallResult(ball, result);
		}

		if (strike == 0 && ball == 0) {
			result.append(Message.NOTHING.getText());
		}

		System.out.println(result);
	}

	private static void buildBallResult(int ball, StringBuilder result) {
		if (ball>0) {
			result.append(ball).append(Message.BALL.getText()).append(" ");
		}
	}

	private static void buildStrikeResult(int strike, StringBuilder result) {
		if (strike>0) {
			result.append(strike).append(Message.STRIKE.getText()).append(" ");
		}
	}

	public static void printGameEndMessage() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}
}
