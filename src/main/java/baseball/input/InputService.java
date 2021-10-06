package baseball.input;

import baseball.utils.ValidationResult;
import baseball.utils.ValidationUtils;
import nextstep.utils.Console;

/**
 * @author KingCjy
 */
public class InputService {

    private static final String READ_BALL_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String READ_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public int[] readBallValue()  {
        ValidationResult result = null;
        String input = null;

        while(result != ValidationResult.SUCCESS) {
            System.out.print(READ_BALL_MESSAGE);
            input = Console.readLine();
            result = ValidationUtils.isValidBallInput(input);
            printErrorMessage(result);
        }
        return stringToIntArray(input);
    }

    public boolean readRestartValue() {
        ValidationResult result = null;
        String input = null;

        while(result != ValidationResult.SUCCESS) {
            System.out.println(READ_RESTART_MESSAGE);
            input = Console.readLine();
            result = ValidationUtils.isValidRestartInput(input);
            printErrorMessage(result);
        }
        return Integer.parseInt(input) == 1;
    }

    private static void printErrorMessage(ValidationResult result) {
        if (result != ValidationResult.SUCCESS) {
            System.out.println(result.getMessage());
        }
    }

    private static int[] stringToIntArray(String input) {
        char[] chars = input.toCharArray();
        int[] result = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            result[i] = Character.getNumericValue(chars[i]);
        }

        return result;
    }
}
