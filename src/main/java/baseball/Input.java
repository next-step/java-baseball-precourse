package baseball;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Console;

public class Input {
	private static final String EMPTY_VALUE = "";
	private static final String BLANK_VALUE = "\\s";

	public static BaseballNumbers readPlayerBaseballNumbers() {
		String inputValue = Console.readLine();
		return new BaseballNumbers(generateNumberList(splitValues(inputValue)));
	}

	private static List<Integer> generateNumberList(String[] splitValues) {
		List<Integer> numbers = new ArrayList<>();
		for (String number : splitValues) {
			numbers.add(Integer.parseInt(number));
		}
		return numbers;
	}

	private static String[] splitValues(String inputValue) {
		return inputValue.replaceAll(BLANK_VALUE, EMPTY_VALUE)
			.split(EMPTY_VALUE);
	}
}
