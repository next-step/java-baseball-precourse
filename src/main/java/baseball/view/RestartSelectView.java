package baseball.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import baseball.exception.InvalidSelectValueException;
import baseball.model.ConstValue;
import nextstep.utils.Console;

public class RestartSelectView {

	private final static Map<String, Boolean> selectOption = new HashMap<>();

	public static boolean printRestartSelectMessage() {

		selectOption.put("1", true);
		selectOption.put("2", false);

		System.out.println(ConstValue.GAME_RESTART_SELECT);
		String restartSelected = Console.readLine();

		try {
			return validateSelectedValue(restartSelected);
		} catch (InvalidSelectValueException exception) {
			System.out.println(exception.getMessage());
			return printRestartSelectMessage();
		}
	}

	private static boolean validateSelectedValue(String selected) {
		boolean isRestart = Optional.ofNullable(selectOption.get(selected))
			.orElseThrow(() -> new InvalidSelectValueException());

		return isRestart;
	}

}
