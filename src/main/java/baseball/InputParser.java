package baseball;

import java.util.ArrayList;

public class InputParser {
    public static final String INPUT_SPLIT_DELIMITER = "";

    public ArrayList<Integer> parse(String input) {
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
