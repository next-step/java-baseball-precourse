package baseball.ui;

import baseball.domain.Number;
import java.util.Objects;
import nextstep.utils.Console;

public class InputHandler {

    private static final int MAX_ATTEMPTS = 5;
    private static final String RETRY_FAILURE_MESSAGE = "[ERROR] " + MAX_ATTEMPTS + "회 초과. 게임 종료.";

    private InputHandler() {
    }

    public static PlayerOption getPlayerOptionWithRetry() {
        PlayerOption playerOption = null;
        for (int i = 0; i < MAX_ATTEMPTS; i++) {
            try {
                playerOption = new PlayerOption(getPlayerOption());
                i = MAX_ATTEMPTS;
            } catch (IllegalArgumentException ex) {
                OutputHandler.printException(ex.getMessage());
            }
        }
        validatePlayerOption(playerOption);
        return playerOption;
    }

    private static String getPlayerOption() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

    private static void validatePlayerOption(PlayerOption playerOption) {
        if (Objects.isNull(playerOption)) {
            throw new IllegalArgumentException(RETRY_FAILURE_MESSAGE);
        }
    }

    public static Number getPlayerNumberWithRetry() {
        Number playerNumber = null;
        for (int i = 0; i < MAX_ATTEMPTS; i++) {
            try {
                playerNumber = new Number(getPlayerNumber());
                i = MAX_ATTEMPTS;
            } catch (IllegalArgumentException ex) {
                OutputHandler.printException(ex.getMessage());
            }
        }
        validatePlayerNumber(playerNumber);
        return playerNumber;
    }

    private static String getPlayerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    private static void validatePlayerNumber(Number playerNumber) {
        if (Objects.isNull(playerNumber)) {
            throw new IllegalArgumentException(RETRY_FAILURE_MESSAGE);
        }
    }
}
