package baseball;

import java.util.ArrayList;

public class InputParser {
    public ArrayList<Integer> parse(String input) {
        String[] splits = input.split("");

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
        if (splits.length != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void verifyNumberRange(int num) {
        if (num < 0 || num > 9) {
            throw new IllegalArgumentException();
        }
    }
}
