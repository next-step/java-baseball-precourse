package baseball;

import java.util.ArrayList;

public class InputParser {
    private static final String INPUT_BALL_NUMBER_ERROR_MSG = "[ERROR] 입력한 값이 유효하지 않습니다. 1~9 사이의 정수값 3개를 입력해주세요...";
    private static final String INPUT_SPLIT_DELIMITER = "";

    public ArrayList<Integer> parse(String input) {
        try {
            return this.parseInternal(input);
        } catch (IllegalArgumentException e) {
            System.out.println(INPUT_BALL_NUMBER_ERROR_MSG);

            return new ArrayList<>();
        }
    }

    private ArrayList<Integer> parseInternal(String input) {
        String[] splits = input.split(INPUT_SPLIT_DELIMITER);

        verifyInputLength(splits);

        return splitsToParsed(splits);
    }

    public int parseInteger(String input) {
        return this.stringToInteger(input);
    }

    private ArrayList<Integer> splitsToParsed(String[] splits) {
        ArrayList<Integer> result = new ArrayList<>();

        for (String split : splits) {
            result.add(stringToInteger(split));
        }

        return result;
    }

    private int stringToInteger(String split) {
        try {
            int num = Integer.parseInt(split);

            verifyNumberRange(num);
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void verifyInputLength(String[] splits) {
        if (splits.length != GlobalVariables.MAX_BALL_CNT) {
            throw new IllegalArgumentException();
        }
    }

    private void verifyNumberRange(int num) {
        if (num < GlobalVariables.MIN_BALL_NUMBER || num > GlobalVariables.MAX_BALL_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}
