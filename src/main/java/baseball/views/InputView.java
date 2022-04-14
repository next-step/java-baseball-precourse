package baseball.views;

import baseball.utils.ValidationUtils;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    private static final String INVALID_INPUT_MESSAGE = "잘못된 입력입니다. (숫자만 입력 가능합니다.)";
    private static final String INVALID_LENGTH_MESSAGE = "%d자리 입력만 가능합니다.";
    private static final String INVALID_INPUT_DUPLICATE_MESSAGE = "중복된 수를 입력할 수 없습니다.";
    private static final int GAME_OVER_FLAG_LENGTH = 1;
    public static final int GAME_CONTINUE_FLAG = 1;
    public static final int GAME_OVER_FLAG = 2;

    public static List<Integer> inputComputerNumber() {
        int computerNumber;
        do {
            computerNumber = 0;
            computerNumber += Randoms.pickNumberInRange(ValidationUtils.MIN_NUMBER, ValidationUtils.MAX_NUMBER) * 100;
            computerNumber += Randoms.pickNumberInRange(ValidationUtils.MIN_NUMBER, ValidationUtils.MAX_NUMBER) * 10;
            computerNumber += Randoms.pickNumberInRange(ValidationUtils.MIN_NUMBER, ValidationUtils.MAX_NUMBER);
        } while (!ValidationUtils.validateDuplication(computerNumber));
        return numberToList(String.valueOf(computerNumber));
    }

    public static List<Integer> inputUserNumber() {
        String userInput = Console.readLine();
        validateUserInput(userInput);
        return numberToList(userInput);
    }

    public static boolean isContinue() {
        String userInput = Console.readLine();
        validateGameOverFlagNumber(userInput);
        return Integer.parseInt(userInput) == GAME_CONTINUE_FLAG;
    }

    private static List<Integer> numberToList(final String number) {
        List<Integer> list = new ArrayList<>();
        for (final char c : number.toCharArray()) {
            list.add(Character.getNumericValue(c));
        }
        return list;
    }

    private static void validateUserInput(final String userInput) {
        if (!ValidationUtils.isNumeric(userInput)) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
        int userNumber = Integer.parseInt(userInput);
        if (!ValidationUtils.validateLength(userNumber, ValidationUtils.FIXED_LENGTH)) {
            throw new IllegalArgumentException(String.format(INVALID_LENGTH_MESSAGE, ValidationUtils.FIXED_LENGTH));
        }
        if (!ValidationUtils.validateDuplication(userNumber)) {
            throw new IllegalArgumentException(INVALID_INPUT_DUPLICATE_MESSAGE);
        }
    }

    private static void validateGameOverFlagNumber(final String userInput) {
        if (!ValidationUtils.isNumeric(userInput)) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
        int gameOverFlagNumber = Integer.parseInt(userInput);
        if (!ValidationUtils.validateLength(gameOverFlagNumber, GAME_OVER_FLAG_LENGTH)) {
            throw new IllegalArgumentException(String.format(INVALID_LENGTH_MESSAGE, GAME_OVER_FLAG_LENGTH));
        }
        if (!ValidationUtils.validateNumberRange(gameOverFlagNumber, GAME_CONTINUE_FLAG, GAME_OVER_FLAG)) {
            throw new IllegalArgumentException(String.format(ValidationUtils.INVALID_INPUT_RANGE_MESSAGE, GAME_CONTINUE_FLAG, GAME_OVER_FLAG));
        }
    }
}
