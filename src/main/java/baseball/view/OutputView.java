package baseball.view;

import baseball.enums.ResultStatus;
import baseball.model.Result;
import baseball.util.InputUtil;

public class OutputView {

	private static final String NOTHING_RESULT_MESSAGE = "낫싱";
	private static final String WINNING_RESULT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String BALL_MESSAGE = "볼 ";
	private static final String STRIKE_MESSAGE = "스트라이크";

	public void printResult(Result result) {
		StringBuilder stringBuilder = new StringBuilder();
		if (result.getStatus().equals(ResultStatus.NOTHING)) {
			printResultMessage(stringBuilder, NOTHING_RESULT_MESSAGE);
			return;
		}

		appendScoreMessage(result, stringBuilder);

		if (result.getStatus().equals(ResultStatus.WIN)) {
			stringBuilder.append(InputUtil.NEXT_LINE);
			printResultMessage(stringBuilder, WINNING_RESULT_MESSAGE);
			return;
		}

		printMessage(stringBuilder.toString());
	}

	private void appendScoreMessage(Result result, StringBuilder sb) {
		appendBallCount(sb, result.getBall());
		appendStrikeCount(sb, result.getStrike());
	}

	private void printResultMessage(StringBuilder sb, String resultMessage) {
		sb.append(resultMessage);
		printMessage(sb.toString());
	}

	private void printMessage(String message) {
		System.out.println(message);
	}

	private void appendBallCount(StringBuilder sb, int ball) {
		if (ball > 0) {
			sb.append(ball).append(BALL_MESSAGE);
		}
	}

	private void appendStrikeCount(StringBuilder sb, int strike) {
		if (strike > 0) {
			sb.append(strike).append(STRIKE_MESSAGE);
		}
	}
}
