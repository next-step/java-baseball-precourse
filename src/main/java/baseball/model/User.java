package baseball.model;

import java.util.*;
import java.util.regex.Pattern;

public class User {

    private static List<Integer> ballCount = new ArrayList<>();

    private static final Pattern REGULAR_EXPRESSION = Pattern.compile("^[1-9]*$");

    private static void storeInputArrayToBallCount(String[] input) {
        for(String element: input) {
            int num = Integer.parseInt(element);
            ballCount.add(num);
        }
    }

    private static void clearBallCount() {
        ballCount.clear();
    }

    private static void checkRegularExpression(String element) throws IllegalArgumentException {
        if (!REGULAR_EXPRESSION.matcher(element).find()) {
            throw new IllegalArgumentException("1~9 사이의 숫자를 입력해주세요.");
        }
    }

    private static void checkInputDigitWithoutZero(String[] input) {
        for (String element: input) {
            checkRegularExpression(element);
        }
    }

    private static void checkInputDuplication(String[] input) {
        Set<String> ballCountSet = new HashSet<>(Arrays.asList(input));
        if (ballCountSet.size() != input.length) {
            throw new IllegalArgumentException("중복되지 않는 숫자를 입력해주세요.");
        }
    }

    private static void checkInputLength(String[] input) {
        if (input.length != 3) {
            throw new IllegalArgumentException("제한된 길이 이하의 숫자를 입력해주세요.");
        }
    }

    private static void checkInputArray(String[] inputArray) {
        checkInputDigitWithoutZero(inputArray);
        checkInputDuplication(inputArray);
        checkInputLength(inputArray);
    }

    public static List<Integer> getBallCount() {
        return ballCount;
    }

    public static void throwBalls(String input) {
        clearBallCount();

        String[] inputArray = input.split("");
        checkInputArray(inputArray);
        storeInputArrayToBallCount(inputArray);
    }
}
