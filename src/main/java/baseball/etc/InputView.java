package baseball.etc;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String OnlyNumberAndThreeDigitLimit = "[" + GameManager.MIN_BALL_NUM + "-" + GameManager.MAX_BALL_NUM + "]{" + GameManager.BALLS_SIZE + "}";
    private static final String OnlyNumberAndOneDigitLimit = "[" + GameManager.GAME_START_FLAG + "-" + GameManager.GAME_OVER_FLAG + "]";

    public static List<Integer> inputBallNumbers() {
        System.out.print("숫자를 입력해 주세요 : ");
        String input = Console.readLine();
        isOnlyNumberAndThreeDigitLimit(input);
        return inputStringToIntegerList(input);
    }

    public static int inputGameOverFlag() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        isOnlyNumberAndOneDigitLimit(input);
        return Character.getNumericValue(input.charAt(0));
    }

    private static void isOnlyNumberAndThreeDigitLimit(final String input) {
        if (!input.matches(OnlyNumberAndThreeDigitLimit)) {
            throw new IllegalArgumentException(GameManager.MIN_BALL_NUM + " ~ " + GameManager.MAX_BALL_NUM + " 사이의 " + GameManager.BALLS_SIZE + "자리 숫자만 입력 가능합니다.");
        }
    }

    private static void isOnlyNumberAndOneDigitLimit(final String input) {
        if (!input.matches(OnlyNumberAndOneDigitLimit)) {
            throw new IllegalArgumentException(GameManager.GAME_START_FLAG + " ~ " + GameManager.GAME_OVER_FLAG + " 사이의 1자리 숫자만 입력 가능합니다.");
        }
    }

    private static List<Integer> inputStringToIntegerList(final String input) {
        List<Integer> result = new ArrayList<>();
        for (char c : input.toCharArray()) {
            result.add(Character.getNumericValue(c));
        }
        return result;
    }
}
