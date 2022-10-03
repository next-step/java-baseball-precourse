package baseball.utils;

import static baseball.utils.Constants.DUPLECATE_NUMBER_EXISTS;
import static baseball.utils.Constants.INCORRECT_INPUT_TYPE;
import static baseball.utils.Constants.INCORRECT_SIZE_OF_NUMBER;
import static baseball.utils.Constants.OUT_OF_INPUT_RANGE;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    public static void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(INCORRECT_INPUT_TYPE);
        }
    }

    public static void isLength(String input, int size) {
        if(input.length() != size) {
            throw new IllegalArgumentException(INCORRECT_SIZE_OF_NUMBER);
        }
    }

    public static void isDuplicate(String input) {
        String[] characterList = input.split("");
        Set<String> inputSet = new HashSet<>(Arrays.asList(characterList));

        if(inputSet.size() != characterList.length) {
            throw new IllegalArgumentException(DUPLECATE_NUMBER_EXISTS);
        }
    }

    public static void isMinMax(String input, int min, int max) {
        int inputNumber = Integer.parseInt(input);
        if(inputNumber < min || inputNumber > max) {
            throw new IllegalArgumentException(OUT_OF_INPUT_RANGE);
        }
    }

    public static void isContinueNum(String input) {

    }
}
