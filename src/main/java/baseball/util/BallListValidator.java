package baseball.util;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import baseball.code.BallConfig;
import baseball.code.ErrorMessage;
import baseball.exception.GameException;

public class BallListValidator {

    public static void inputValidate(String inputUserBallList) {
        validateInputSize(inputUserBallList);
        validateIsNumber(inputUserBallList);
        validateDuplicateNumber(inputUserBallList);
    }

    public static void validateInputSize(String inputUserBallList) {
        if (inputUserBallList.length() != BallConfig.BALL_LIST_SIZE.getBallConfig()) {
            throw new GameException(ErrorMessage.INVALID_BALL_LIST_SIZE.getErrorMessage());
        }
    }

    public static void validateIsNumber(String inputUserBallList) {
        Pattern isNumber = Pattern.compile("^[1-9]*?");
        if (!isNumber.matcher(inputUserBallList).matches()) {
            throw new GameException(ErrorMessage.INVALID_BALL_VALUE_TYPE.getErrorMessage());
        }
    }

    public static void validateDuplicateNumber(String inputUserBallList) {
        if (removeDuplicate(inputUserBallList) != BallConfig.BALL_LIST_SIZE.getBallConfig()) {
            throw new GameException(ErrorMessage.INVALID_BALL_DUPLICATE.getErrorMessage());
        }
    }

    private static int removeDuplicate(String inputUserBallList) {
        Set<Character> removeDuplicate = new HashSet<>();
        for (Character ball : inputUserBallList.toCharArray()) {
            removeDuplicate.add(ball);
        }
        return removeDuplicate.size();
    }
}
