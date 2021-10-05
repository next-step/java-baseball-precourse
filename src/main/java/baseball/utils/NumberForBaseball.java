package baseball.utils;

import java.util.HashSet;

import baseball.exception.NotThreeDigitNumberException;

public class NumberForBaseball {
	public static final int NUMBER_OF_DIGITS_FOR_BASEBALL = 3;

	private static void isThreeDigitsNumber(int number) {
		if (number < 0 || String.valueOf(number).length() != NUMBER_OF_DIGITS_FOR_BASEBALL) {
			throw new NotThreeDigitNumberException();
		}
	}

	public static char[] getDigitsArray(int number) {
		isThreeDigitsNumber(number);
		return String.valueOf(number).toCharArray();
	}

	public static boolean hasDuplicateDigits(int number) {
		isThreeDigitsNumber(number);
		char[] digits = getDigitsArray(number);
		HashSet<Character> set = new HashSet<>();
		for (int i = 0; i < NUMBER_OF_DIGITS_FOR_BASEBALL; i++) {
			set.add(digits[i]);
		}
		return !(digits.length == set.size());
	}
}
