package baseball.controller.validation;

import java.util.Arrays;

public class DifferentNumberValidator implements Validator {
    @Override
    public void check(String input) {
        String[] split = input.split("");
        int[] sort = new int[LIMIT_LENGTH];
        for (int i = 0; i < LIMIT_LENGTH; i++) {
            sort[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(sort);
        for (int i = 0; i < LIMIT_LENGTH - 1; i++) {
            isFindSameNumberThenThrow(sort, i);
        }
    }

    private void isFindSameNumberThenThrow(int[] sort, int i) {
        if (sort[i] == sort[i + 1]) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
