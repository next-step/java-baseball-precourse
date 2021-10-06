package baseball.view;

import baseball.domain.Message;
import baseball.domain.Umpire;

public class OutputView {
	
	public static void printCall(Umpire umpire) {
		int ballCount = umpire.getBallCount();
		int strikeCount = umpire.getStrikeCount();
		printNothingMessage(strikeCount, ballCount);
		printResultMessage(strikeCount, ballCount);
	}

	private static void printResultMessage(int strikeCount, int ballCount) {
		if (strikeCount != 0 && ballCount != 0) {
			System.out.println(String.format(Message.STRIKE_BALL.getValue(), strikeCount, ballCount));
			return;
		}
		printStrikeMessage(strikeCount);
		printBallMessage(ballCount);
	}

	private static void printStrikeMessage(int strikeCount) {
		if (strikeCount != 0)
			System.out.println(String.format(Message.STRIKE.getValue(), strikeCount));
	}

	private static void printBallMessage(int ballCount) {
		if (ballCount != 0)
			System.out.println(String.format(Message.BALL.getValue(), ballCount));
	}

	private static void printNothingMessage(int strikeCount, int ballCount) {
		if (strikeCount == 0 && ballCount == 0)
			System.out.println(Message.NOTHING.getValue());
	}

	public static void printWinningMessage() {
		System.out.println(Message.WINNING.getValue());
	}
}
