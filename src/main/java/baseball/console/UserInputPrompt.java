package baseball.console;

import nextstep.utils.Console;
import java.util.regex.Pattern;

public class UserInputPrompt {
    private static final String RESTART = "1";
    private static final String END = "2";
    private static final String pattern = "^[1-9]*$";
    private static final String USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String USER_SELECT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String USER_INPUT_ERROR_MESSAGE = "사용자 입력값 오류입니다.[1-9]사이의 값만 가능합니다.";
    public static final String USER_SELECT_ERROR_MESSAGE = "사용자 입력값 오류입니다.게임이 계속 진행됩니다.";

    public static String getUserInputValue() {
        System.out.println(USER_INPUT_MESSAGE);
        String userInputValue = Console.readLine();
        boolean regexNumRange = Pattern.matches(pattern, userInputValue);

        if (!regexNumRange) {
            throw new IllegalArgumentException(USER_INPUT_ERROR_MESSAGE);
        }
        return userInputValue;
    }

    public static String getUserSelectGameMode() {
        System.out.println(USER_SELECT_MESSAGE);
        String userSelectGameMode = Console.readLine();

        if (!RESTART.equals(userSelectGameMode) && !END.equals(userSelectGameMode)) {
            throw new IllegalArgumentException(USER_SELECT_ERROR_MESSAGE);
        }
        return userSelectGameMode;
    }
}
