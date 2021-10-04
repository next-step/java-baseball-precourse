package baseball.view;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Console;

public class InputView {

	private static final int INPUT_SIZE = 3;
	private static final int START_INDEX = 0;
	private static final int END_INDEX = 9;
	private static final int END_INPUT_SIZE = 1;
	private static final int GAME_CONTINUE_NUMBER = 1;
	private static final int GAME_END_NUMBER = 2;

	public List<Integer> inputNumbers() {
		final String input = Console.readLine();

		if (input.length() != INPUT_SIZE) {
			throw new NumberFormatException();
		}

		return stringToInteger(input);
	}

	private List<Integer> stringToInteger(String input) {
		List<Integer> numbers = new ArrayList<>();
		for (int i = START_INDEX; i < input.length(); i++) {
			numbers.add(characterToInt(input.charAt(i)));
		}
		return numbers;
	}

	private int characterToInt(char c) {
		int input = c - '0';
		if (input < START_INDEX || input > END_INDEX) {
			throw new NumberFormatException();
		}
		return input;
	}

	public boolean inputEndNumber() {
		final String input = Console.readLine();

		if (input.length() != END_INPUT_SIZE) {
			throw new NumberFormatException();
		}

		final int inputNumber = Integer.parseInt(input);
		if (inputNumber != GAME_CONTINUE_NUMBER && inputNumber != GAME_END_NUMBER) {
			throw new NumberFormatException();
		}
		return inputNumber == GAME_CONTINUE_NUMBER;
	}
}
