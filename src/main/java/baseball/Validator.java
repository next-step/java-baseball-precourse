package baseball;

import java.util.HashSet;
import java.util.Set;

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
			throw new IllegalArgumentException(ErrorMessageType.INVALID_DIGITS.getMessage());
		}

		if (!isCorrectRange(input)) {
			throw new IllegalArgumentException(ErrorMessageType.INVALID_RANGE_OF_NUMBER.getMessage());
		}

		if (isDuplicated(input)) {
			throw new IllegalArgumentException(ErrorMessageType.DUPLICATED_NUMBER.getMessage());
		}
	}

	public enum ErrorMessageType {

		INVALID_DIGITS("세 자리수를 입력하세요."),
		INVALID_RANGE_OF_NUMBER("1~9 사이의 숫자만 입력하세요."),
		DUPLICATED_NUMBER("중복되지 않는 숫자를 입력하세요.");

		private String message;

		private ErrorMessageType(String message) {
			this.message = message;
		}

		public String getMessage() {
			return this.message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}
}
