package baseball.domain;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Digits {
    private Digit[] digits;

    public Digits(Digit[] digits) {
        validate(digits.length, "the length of digits should be 3 but: " + digits.length);
        this.digits = digits;
    }

    private static void validate(int length, String payload) {
        if (length != 3) {
            throw new IllegalArgumentException(payload);
        }
    }

    public static Digits build(int first, int second, int third) {
        Digit[] digits = new Digit[]{
                new Digit(first),
                new Digit(second),
                new Digit(third)
        };
        return new Digits(digits);
    }

    public static Digits parse(String input) {
        validate(input.length(), "input should be 3 digits but: " + input);
        Digit[] digits = new Digit[3];
        for (int i = 0; i < input.length(); i++) {
            digits[i] = Digit.parse(input.charAt(i));
        }
        return new Digits(digits);
    }


    public static Digits generate() {
        int first = pickNumberInRange(0, 9);
        int second = pickNumberInRange(0, first - 1);
        int third = pickNumberInRange(second + 1, 9);
        int[] renewed = renewDuplicated(first, second, third);
        second = renewed[0];
        third = renewed[1];
        return build(first, second, third);
    }

    private static int[] renewDuplicated(int first, int second, int third) {
        int newSecond = second;
        int newThird = third;
        if (first == 0) {
            newSecond = pickNumberInRange(first + 1, 9);
            newThird = pickUniqueNumberInSubrange(second, first + 1, 9);
        }
        if (first == 9) {
            newSecond = pickNumberInRange(0, first - 1);
            newThird = pickUniqueNumberInSubrange(second, 0, first - 1);
        }
        return new int[]{newSecond, newThird};
    }

    private static int pickUniqueNumberInSubrange(int second, int first, int endInclusive) {
        if (second == 0) {
            return pickNumberInRange(second + 1, endInclusive);
        }
        if (second == 9) {
            return pickNumberInRange(first, second - 1);
        }
        throw new RuntimeException("Unreachable");
    }

    public Score match(Digits inputDigits) {
        Digit[] inputDigitArray = inputDigits.digits;
        Score score = new Score(0, 0);
        for (int inputDigitIndex = 0; inputDigitIndex < inputDigitArray.length; inputDigitIndex++) {
            score = renewScoreWithDigits(inputDigitArray, score, inputDigitIndex);
        }

        return score;
    }

    private Score renewScoreWithDigits(Digit[] inputDigits, Score score, int inputDigitIndex) {
        for (int digitIndex = 0; digitIndex < digits.length; digitIndex++) {
            score = renewScore(inputDigits, score, inputDigitIndex, digitIndex);
            continue;
        }
        return score;
    }

    private Score renewScore(Digit[] inputDigits, Score score, int inputDigitIndex, int digitIndex) {
        if (isStrike(digits[digitIndex], inputDigits[inputDigitIndex], inputDigitIndex, digitIndex)) {
            return score.addStrike();
        }
        if (isBall(digits[digitIndex], inputDigits[inputDigitIndex])) {
            return score.addBall();
        }
        return score;
    }

    private boolean isBall(Digit digit, Digit inputDigit) {
        return digit.equals(inputDigit);
    }

    private boolean isStrike(Digit digit, Digit inputDigit, int inputDigitIndex, int digitIndex) {
        return isBall(digit, inputDigit) && inputDigitIndex == digitIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Digits digits = (Digits) o;
        return Arrays.equals(this.digits, digits.digits);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(digits);
    }

    @Override
    public String toString() {
        return "Digits{" +
                "digits=" + Arrays.toString(digits) +
                '}';
    }
}
