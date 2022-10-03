package baseball.io;

import baseball.message.GameMessage;
import baseball.model.PlayResult;

public interface Output {
	void printMessage(GameMessage message);
	void printResult(PlayResult result);
}
