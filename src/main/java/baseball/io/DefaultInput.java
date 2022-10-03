package baseball.io;

import baseball.message.GameMessage;
import camp.nextstep.edu.missionutils.Console;

public class DefaultInput implements Input {

	@Override
	public String getUserBalls() {
		System.out.print(GameMessage.INPUT_NUMBER);
		return Console.readLine();
	}

	@Override
	public String getEndCommand() {
		System.out.println(GameMessage.NEW_GAME_OR_EXIT);
		return Console.readLine();
	}
}
