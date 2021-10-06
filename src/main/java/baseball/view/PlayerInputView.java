package baseball.view;

import baseball.model.ConstValue;
import baseball.model.PlayerBaseballNumber;
import nextstep.utils.Console;

public class PlayerInputView {

	public static PlayerBaseballNumber inputBaseballNumber() {
		System.out.println(ConstValue.PLAYER_INPUT_NUMBER);
		String playerNumbers = Console.readLine();

		return PlayerBaseballNumber.createPlayerBaseballNumber(playerNumbers);
	};
}
