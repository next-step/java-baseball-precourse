package baseball.utils;

import java.util.ArrayList;

public class InputParser {
    private static final String INPUT_BALL_NUMBER_ERROR_MSG = "[ERROR] 입력한 값이 유효하지 않습니다. 1~9 사이의 정수값 3개를 입력해주세요...";
    private static final String INPUT_SPLIT_DELIMITER = "";

    private InputValidator inputValidator;

    public InputParser() {
        this.inputValidator = new InputValidator();
    }

    public ArrayList<Integer> parse(String input) {
        try {
            return this.parseInternal(input);
        } catch (IllegalArgumentException e) {
            System.out.println(INPUT_BALL_NUMBER_ERROR_MSG);

            return new ArrayList<>();
        }
    }

    private ArrayList<Integer> parseInternal(String input) {
        String[] splits = splitInput(input);

        return splitsToParsed(splits);
    }

    private String[] splitInput(String input) {
        String[] splits = input.split(INPUT_SPLIT_DELIMITER);

        if (!this.inputValidator.validateLength(splits)) {
            throw new IllegalArgumentException();
        }

        return splits;
    }

    private ArrayList<Integer> splitsToParsed(String[] splits) {
        ArrayList<Integer> result = new ArrayList<>();

        for (String split : splits) {
            result.add(stringToInt(split));
        }

        return result;
    }

    private int stringToInt(String split) {
        try {
            return stringToIntInternal(split);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private int stringToIntInternal(String split) {
        int num = Integer.parseInt(split);

        if (!this.inputValidator.validateRange(num)) {
            throw new IllegalArgumentException();
        }

        return num;
    }
}
