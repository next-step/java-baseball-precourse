package baseball.view;

import static baseball.utils.Hint.*;

import nextstep.utils.Console;

public class GameInput {

	public String inputMessage() {
		System.out.print(INPUT.getHint());
		return Console.readLine();
	}

	public boolean isRestart() {
		System.out.println(RESTART.getHint());
		return Console.readLine().equals("1");
	}
}
