package util;

import java.util.HashSet;
import java.util.Set;

import domain.MessageType;

public class Validator {

	private static final int DEFAULT_LENGTH = 3;

	protected boolean isCorrectDigits(String input) {
		return isCorrectDigits(input, DEFAULT_LENGTH);
	}

	protected boolean isCorrectDigits(String input, int length) {
		return input != null && input.length() == length;
	}

	protected boolean isCorrectRange(String input) {

		for (char c : input.toCharArray()) {
			if (!isCorrectRange(c)) {
				return false;
			}
		}
		return true;
	}

	private boolean isCorrectRange(char c) {
		if (Character.isDigit(c) && c - '0' != 0) {
			return true;
		}
		return false;
	}

	protected boolean isDuplicated(String input) {
		Set<Character> set = new HashSet<>();
		for (char c : input.toCharArray()) {
			if (!set.add(c)) {
				return true;
			}
		}
		return false;
	}

	public void isValid(String input) throws IllegalArgumentException {

		if (!isCorrectDigits(input)) {
			throw new IllegalArgumentException(MessageType.INVALID_DIGITS.getMessage());
		}

		if (!isCorrectRange(input)) {
			throw new IllegalArgumentException(MessageType.INVALID_RANGE_OF_NUMBER.getMessage());
		}

		if (isDuplicated(input)) {
			throw new IllegalArgumentException(MessageType.DUPLICATED_NUMBER.getMessage());
		}
	}
}
