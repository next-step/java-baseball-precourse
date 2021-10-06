package baseball;

import baseball.ball.Ball;
import baseball.service.BaseballService;
import baseball.utils.ValidationUtils;
import nextstep.utils.Console;

/**
 * @author KingCjy
 */
public class Baseball {

    private static final int BALL_LENGTH = 3;
    private static final BaseballService baseballService = new BaseballService();

    private Baseball() {

    }

    public static void start() {
        initGame();
    }

    private static void initGame() {
        Ball computerBall = baseballService.generateBall();
        Ball ball = readValue();

        System.out.println(ball);
    }

    private static Ball readValue() {
        boolean isValid = false;
        String input = null;

        while(!isValid) {
            System.out.println("숫자를 입력해주세요 : ");
            input = Console.readLine();
            isValid = ValidationUtils.isValidInput(input);
            printErrorMessage(isValid);
        }

        return new Ball(stringToIntArray(input));
    }

    private static void printErrorMessage(boolean isValid) {
        if (!isValid) {
            System.out.println("[ERROR] 잘못된 입력입니다.");
        }
    }

    private static int[] stringToIntArray(String input) {
        return intToArray(Integer.parseInt(input));
    }

    private static int[] intToArray(int number) {
        char[] chars = Integer.toString(number).toCharArray();
        int[] result = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            result[i] = Character.getNumericValue(chars[i]);
        }

        return result;
    }
}
