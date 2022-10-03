package baseball.service;

import baseball.domain.BaseballPlayer;
import baseball.domain.BaseballResult;

public class BaseballReferee implements Referee<BaseballPlayer, BaseballResult> {

    public static final int START_INCLUSIVE = 0;
    public static final int END_INCLUSIVE = 9;
    public static final int NUMBER_SIZE = 3;

    @Override
    public void checkCommand(String command) {
        if (command == null) {
            throw new IllegalArgumentException("숫자를 입력하여 주세요.");
        } else if (isDifferentSize(command)) {
            throw new IllegalArgumentException(String.format("숫자는 %d 자리만 입력하여 주세요.", NUMBER_SIZE));
        } else if (isCommandContainsNonDigit(command)) {
            throw new IllegalArgumentException("숫자만 입력하여 주세요.");
        } else if (isNumberDuplicate(command)) {
            throw new IllegalArgumentException("숫자가 중복되지 않게 입력하여 주세요.");
        }
    }

    @Override
    public BaseballResult compareNumber(BaseballPlayer player1, BaseballPlayer player2) {
        return player1.compare(player2);
    }

    private boolean isDifferentSize(String command) {
        return command.length() != NUMBER_SIZE;
    }

    private boolean isCommandContainsNonDigit(String command) {
        final String REGEX = "[0-9]+";
        return !command.matches(REGEX);
    }

    private boolean isNumberDuplicate(String command) {
        int[] numbers = new int[10];
        int count = 0;

        for (int i = 0; i < command.length(); i++) {
            char ch = command.charAt(i);
            numbers[ch - 48]++;
            count = Math.max(numbers[ch - 48] , count);
        }

        return count >= 2;
    }
}
