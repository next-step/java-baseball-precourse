package baseball.view;

import java.io.PrintStream;

import baseball.model.BallCount;

public class OutputView {

	private static final int ZERO = 0;
	private static final String EMPTY_STRING = "";
	private static final String STRIKE_MESSAGE = "%d스트라이크 ";
	private static final String BALL_MESSAGE = "%d볼";
	private static final String NOTHING_MESSAGE = "낫싱";
	private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String ROUND_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";
	private static final String RESTART_CHECK_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private static final String GAME_END_MESSAGE = "게임이 종료되었습니다.";
	private static final PrintStream OUTPUT = System.out;

	public void printInputNumber() {
		OUTPUT.print(INPUT_NUMBER_MESSAGE);
	}

	public void printGameResult(BallCount ballCount) {
		String resultMessage = appendStrikeMessage(ballCount) + appendBallMessage(ballCount) + appendNothingMessage(ballCount);
		OUTPUT.println(resultMessage.trim());
	}

	private String appendNothingMessage(BallCount ballCount) {
		if (ballCount.isNothing()) {
			return NOTHING_MESSAGE;
		}
		return EMPTY_STRING;
	}

	private String appendBallMessage(BallCount ballCount) {
		if (ballCount.countBall() > ZERO) {
			return String.format(BALL_MESSAGE, ballCount.countBall());
		}
		return EMPTY_STRING;
	}

	private String appendStrikeMessage(BallCount ballCount) {
		if (ballCount.countStrike() > ZERO) {
			return String.format(STRIKE_MESSAGE, ballCount.countStrike());
		}
		return EMPTY_STRING;
	}

	public void printRoundEnd() {
		OUTPUT.println(ROUND_END_MESSAGE);
	}

	public void printRestartCheck() {
		OUTPUT.println(RESTART_CHECK_MESSAGE);
	}

	public void printGameEnd() {
		OUTPUT.println(GAME_END_MESSAGE);
	}
}
