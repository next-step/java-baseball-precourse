package baseball.common;

import static baseball.common.ErrorMessage.*;
import static java.lang.Integer.*;

/**
 * @author garden.iee
 */
public enum GameStatus {
	RESTART(1),
	FINISH(2);

	private final int value;

	GameStatus(final int value) {
		this.value = value;
	}

	public static void validate(final String userInput) {
		if (!isEquals(RESTART, userInput) && !isEquals(FINISH, userInput)) {
			throw new IllegalArgumentException(INPUT_ONLY_ALLOW_NUMBERS.getMessage());
		}
	}

	public static GameStatus getGameStatus(final String input) {
		if (isEquals(RESTART, input)) {
			return RESTART;
		}
		return FINISH;
	}

	private static boolean isEquals(final GameStatus gameStatus, final String input) {
		return gameStatus.getValue() == parseInt(input);
	}

	public int getValue() {
		return value;
	}
}