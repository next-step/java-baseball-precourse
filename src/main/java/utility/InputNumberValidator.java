package utility;

public class InputNumberValidator {

    private static final char OUT_OF_RANGE_DIGIT = '0';

    protected static void checkStringLengthCorrect(String string, int stringLength) {
        if (string.length() != stringLength) {
            raiseIllegalArgumentException();
        }
    }

    protected static void checkStringNumeric(String string) throws IllegalArgumentException {
        for (int i = 0; i < string.length(); i++) {
            checkCharacterNumeric(string.charAt(i));
        }
    }

    private static void checkCharacterNumeric(char singleCharacter) {
        if (!Character.isDigit(singleCharacter) || singleCharacter == OUT_OF_RANGE_DIGIT) {
            raiseIllegalArgumentException();
        }
    }

    protected static void checkDifferentDigitNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (getDigitCount(number, number.charAt(i)) != 1) {
                raiseIllegalArgumentException();
            }
        }
    }

    private static int getDigitCount(String number, char digit) {
        return Math.toIntExact(number.chars()
                .filter((ch) -> (ch == digit))
                .count());
    }

    protected static void raiseIllegalArgumentException() {
        throw new IllegalArgumentException("잘못된 입력입니다.");
    }
}
