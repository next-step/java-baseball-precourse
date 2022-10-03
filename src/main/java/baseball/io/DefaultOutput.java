package baseball.io;

import baseball.message.GameMessage;
import baseball.model.PlayResult;

public class DefaultOutput implements Output {

	@Override
	public void printMessage(GameMessage message) {
		System.out.println(message);
	}

	@Override
	public void printResult(PlayResult result) {
		if (result.isNothing()) {
			System.out.print("낫싱");
		} else if (result.getBall() > 0 && result.getStrike() > 0) {
			System.out.printf(GameMessage.BALL_STRIKE.toString(), result.getBall(), result.getStrike());
		} else if (result.getBall() > 0) {
			System.out.printf(GameMessage.BALL.toString(), result.getBall());
		} else if (result.getStrike() > 0) {
			System.out.printf(GameMessage.STRIKE.toString(), result.getStrike());
		}
		System.out.println();
	}
}
