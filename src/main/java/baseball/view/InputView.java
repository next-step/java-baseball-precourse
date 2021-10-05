package baseball.view;

import baseball.domain.Player;
import baseball.exception.DuplicateNumberException;
import baseball.exception.InvalidNumberRangeException;
import baseball.exception.InvalidNumbersSizeException;
import nextstep.utils.Console;

public final class InputView {
	private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String RESTART_GAME_MESSAGE_FORMAT = "게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.";
	private static final String ERROR_INVALID_INPUT_VALUE_MESSAGE_FORMANT = "[ERROR] 잘못된 값을 입력했습니다. %s";

	private InputView() {
	}

	public static Player getPlayer() {
		try {
			System.out.println(INPUT_NUMBER_MESSAGE);
			return Player.create(Console.readLine());
		} catch (InvalidNumberRangeException | InvalidNumbersSizeException | DuplicateNumberException e) {
			printErrorInvalidInPutValueMessage(e.getMessage());
			return getPlayer();
		}
	}

	public static boolean isRestartGame() {
		askRestartGameMessage();

		String commandString = Console.readLine();
		GameConsoleCommand command = GameConsoleCommand.findFirstOrNull(commandString);
		if (command == null) {
			printErrorInvalidInPutValueMessage(commandString);
			return isRestartGame();
		}

		return GameConsoleCommand.RESTART_GAME == command;
	}

	private static void askRestartGameMessage() {
		System.out.println(String.format(RESTART_GAME_MESSAGE_FORMAT,
			GameConsoleCommand.RESTART_GAME.getCommandStringValue(),
			GameConsoleCommand.END_GAME.getCommandStringValue()));
	}

	private static void printErrorInvalidInPutValueMessage(String message) {
		System.err.println(String.format(ERROR_INVALID_INPUT_VALUE_MESSAGE_FORMANT, message));
	}
}
