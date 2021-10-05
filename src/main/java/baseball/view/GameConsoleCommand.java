package baseball.view;

import java.util.ArrayList;
import java.util.List;

import baseball.utils.CollectionUtils;

public enum GameConsoleCommand {
	RESTART_GAME("1"),
	END_GAME("2");

	private final String value;

	GameConsoleCommand(String value) {
		this.value = value;
	}

	public static GameConsoleCommand findFirstOrNull(String value) {
		List<GameConsoleCommand> result = getGameCommandsByCommandStringValue(value);
		return CollectionUtils.isEmpty(result) ? null : result.get(0);
	}

	public String getCommandStringValue() {
		return value;
	}

	private static List<GameConsoleCommand> getGameCommandsByCommandStringValue(String value) {
		List<GameConsoleCommand> result = new ArrayList<>();
		for (GameConsoleCommand command : CollectionUtils.listOf(GameConsoleCommand.values())) {
			addIfGameCommandEqualsOfValue(result, command, value);
		}
		return result;
	}

	private static void addIfGameCommandEqualsOfValue(List<GameConsoleCommand> list, GameConsoleCommand command,
		String value) {
		if (command.equalsOfValue(value)) {
			list.add(command);
		}
	}

	private boolean equalsOfValue(String value) {
		return this.value.equals(value);
	}
}
