package baseball.type;

import static baseball.type.ErrorMessageType.INPUT_ONLY_ALLOW_NUMBER;
import static baseball.util.StringUtils.parseInt;

public enum GameOverType {
    RESTART(1),
    FINISH(2);

    private final int value;

    GameOverType(final int value) {
        this.value = value;
    }

    public static void isGameOverType(final String input) {
        if (!isEquals(RESTART, input) && !isEquals(FINISH, input)) {
            throw new IllegalArgumentException(INPUT_ONLY_ALLOW_NUMBER.getMessage());
        }
    }

    public static GameOverType getGameOverTypeByInput(final String input) {
        if (isEquals(RESTART, input)) {
            return RESTART;
        }
        return FINISH;
    }

    private static boolean isEquals(final GameOverType gameOverType, final String input) {
        return gameOverType.getValue() == parseInt(input);
    }

    public int getValue() {
        return value;
    }
}
