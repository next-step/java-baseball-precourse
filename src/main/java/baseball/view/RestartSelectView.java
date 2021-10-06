package baseball.view;

import baseball.exception.InvalidSelectValueException;
import baseball.model.ConstValue;
import nextstep.utils.Console;

public class RestartSelectView {

	public static boolean printRestartSelectMessage() {
		System.out.println(ConstValue.GAME_RESTART_SELECT);
		String restartSelected = Console.readLine();

		if(!(restartSelected == "1" || restartSelected == "2"))
			throw new InvalidSelectValueException();

		if(restartSelected == "1")
			return true;

		return false;
	};

}
