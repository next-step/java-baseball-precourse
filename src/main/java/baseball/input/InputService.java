package baseball.input;

import baseball.utils.ValidationUtils;
import nextstep.utils.Console;

/**
 * @author KingCjy
 */
public class InputService {

    private static final String READ_BALL_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String ERROR_MESSAGE = "[ERROR] 잘못된 입력입니다. 다시 입력해주세요.";

    public int[] readBallValue()  {
        boolean isValid = false;
        String input = null;

        while(!isValid) {
            System.out.print(READ_BALL_MESSAGE);
            input = Console.readLine();
            isValid = ValidationUtils.isValidInput(input);
            printErrorMessage(isValid);
        }
        return stringToIntArray(input);
    }

    private static void printErrorMessage(boolean isValid) {
        if (!isValid) {
            System.out.println(ERROR_MESSAGE);
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
