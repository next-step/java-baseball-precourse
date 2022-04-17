package baseball;

import java.util.List;

public class BaseBallGameAnswerComparator {

    private static final int ZERO_ASCII = 48;

    public static BaseBallGameHint compare(final List<Integer> target, final String value) {
        char[] chars = value.toCharArray();

        BaseBallGameHint hint = new BaseBallGameHint();
        for (int i = 0; i < chars.length; i++) {
            int actual = chars[i] - ZERO_ASCII;

            boolean isExactlyMatch = target.get(i) == actual;
            increaseMatchCountIf(isExactlyMatch, hint::increaseStrikeCount);
            increaseMatchCountIf(!isExactlyMatch && target.contains(actual), hint::increaseBallCount);
        }

        return hint;
    }

    private static void increaseMatchCountIf(final boolean condition, final Runnable increaseRunnable) {
        if (condition) {
            increaseRunnable.run();
        }
    }

}
