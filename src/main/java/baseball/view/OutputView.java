package baseball.view;

import static baseball.view.OutputView.Message.*;

import baseball.model.BallCount;

public class OutputView {

	private static final int ZERO = 0;

	public void printInputNumber() {
		System.out.print(INPUT_NUMBER_MESSAGE);
	}

	public void printGameResult(BallCount ballCount) {
		String resultMessage = appendStrikeMessage(ballCount) + appendBallMessage(ballCount) + appendNothingMessage(ballCount);
		System.out.println(resultMessage.trim());
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
		System.out.println(ROUND_END_MESSAGE);
	}

	public void printRestartCheck() {
		System.out.println(RESTART_CHECK_MESSAGE);
	}

	public void printGameEnd() {
		System.out.println(GAME_END_MESSAGE);
	}

	public void printUserInputError() {
		System.out.println(USER_INPUT_ERROR_MESSAGE);
	 }

	 static class Message {
		 static final String EMPTY_STRING = "";
		 static final String STRIKE_MESSAGE = "%d스트라이크 ";
		 static final String BALL_MESSAGE = "%d볼";
		 static final String NOTHING_MESSAGE = "낫싱";
		 static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
		 static final String ROUND_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";
		 static final String RESTART_CHECK_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
		 static final String GAME_END_MESSAGE = "게임이 종료되었습니다.";
		 static final String USER_INPUT_ERROR_MESSAGE = "[ERROR] 사용자 입력이 잘못되었습니다.";
	 }
}
