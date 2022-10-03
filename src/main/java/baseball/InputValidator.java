package baseball;

import static baseball.ErrorMessage.*;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author garden.iee
 */
public class InputValidator {

	void validateBlank(String input) {
		if (isNullOrEmpty(input) || isWhitespace(input)) {
			throw new IllegalArgumentException(INPUT_NOT_ALLOW_BLANK.getMessage());
		}
	}

	void validateLength(String input) {
		if (input.length() != 3) {
			throw new IllegalArgumentException(INPUT_ONLY_ALLOW_THREE_DIGITS.getMessage());
		}
	}

	int validateNumber(String input) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(INPUT_ONLY_ALLOW_NUMBERS.getMessage());
		}
	}

	void validateDuplicate(String input) {
		Set<Character> characters = toCharacters(input);
		if (characters.size() != 3) {
			throw new IllegalArgumentException(INPUT_NOT_ALLOW_DUPLICATE.getMessage());
		}
	}

	private boolean isWhitespace(String input) {
		for (int i = 0; i < input.length(); i++) {
			char charAt = input.charAt(i);
			if (Character.isWhitespace(charAt)) {
				return true;
			}
		}
		return false;
	}

	private boolean isNullOrEmpty(String input) {
		return input == null || input.length() == 0;
	}

	private Set<Character> toCharacters(String input) {
		Set<Character> characters = new LinkedHashSet<>();
		for (char character : input.toCharArray()) {
			characters.add(character);
		}
		return characters;
	}
}