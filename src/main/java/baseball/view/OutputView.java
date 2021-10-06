package baseball.view;

import baseball.domain.Message;
import baseball.domain.Role;

/**
 * @author theco2de
 * @version 1.0
 * @since 1.0
 */
public class OutputView {

	/**
	 * 판정된 스트라이크와 볼로 결과 출력
	 * @param role
	 */
	public static void printCall(Role role) {
		int ballCount = role.getBallCount();
		int strikeCount = role.getStrikeCount();
		printNothingMessage(strikeCount, ballCount);
		printResultMessage(strikeCount, ballCount);
	}

	/**
	 * 스트라이크와 볼 결과 출력
	 * @param strikeCount
	 * @param ballCount
	 */
	private static void printResultMessage(int strikeCount, int ballCount) {
		if (strikeCount != 0 && ballCount != 0) {
			System.out.println(String.format(Message.STRIKE_BALL.getValue(), strikeCount, ballCount));
			return;
		}
		printStrikeMessage(strikeCount);
		printBallMessage(ballCount);
	}

	/**
	 * 스트라이크 결과 출력
	 * @param strikeCount
	 */
	private static void printStrikeMessage(int strikeCount) {
		if (strikeCount != 0)
			System.out.println(String.format(Message.STRIKE.getValue(), strikeCount));
	}

	/**
	 * 볼 결과 출력
	 * @param ballCount
	 */
	private static void printBallMessage(int ballCount) {
		if (ballCount != 0)
			System.out.println(String.format(Message.BALL.getValue(), ballCount));
	}

	/**
	 * 낫싱 결과 출력
	 * @param ballCount
	 */
	private static void printNothingMessage(int strikeCount, int ballCount) {
		if (strikeCount == 0 && ballCount == 0)
			System.out.println(Message.NOTHING.getValue());
	}

	/**
	 * 게임 종료 결과 출력
	 */
	public static void printWinningMessage() {
		System.out.println(Message.WINNING.getValue());
	}
}
