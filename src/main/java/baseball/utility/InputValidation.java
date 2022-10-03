package baseball.utility;

import java.util.HashSet;
import java.util.Set;

public class InputValidation {
	private static int NUMBER_LENGTH = 3;

	public static void validIntegerFormat(String inputString) {
		try {
			validStringLength(inputString);
			validSameNumber(Integer.parseInt(inputString));
			Integer.parseInt(inputString);
		} catch (RuntimeException e) {
			throw new IllegalArgumentException();
		}
	}
	public static void validStringLength(String inputString) {
		if(inputString.length() != NUMBER_LENGTH) {
			throw new IllegalArgumentException();
		}
	}

	public static void validSameNumber(int inputNumber) {
		Set<Integer> numberSet = new HashSet<>();
		int calculateNumber = inputNumber;
		while(calculateNumber != 0) {
			numberSet.add(calculateNumber % 10);
			calculateNumber /= 10;
		}

		if(numberSet.size() != NUMBER_LENGTH) {
			throw new IllegalArgumentException();
		}
	}
}
