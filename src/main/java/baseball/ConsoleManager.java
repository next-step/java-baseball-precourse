package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class ConsoleManager {
	private static Pattern VALID_PATTERN = Pattern.compile("^\\d{3}$");

	public static Integer readOne() {
		return read(1)[0];
	}

	public static Integer[] readThree() {
		return read(3);
	}

	public static Integer[] read(int length) {
		String input = Console.readLine();
		return parse(input, length);
	}

	private static boolean validate(String input, int length) {
		String regex = String.format("^\\d{%d}$", length);
		if (!Pattern.matches(regex, input)) {
			return false;
		}

		return true;
	}

	private static Integer[] parse(String input, int length) {
		if (!validate(input, length)) { throw new IllegalArgumentException(); }

		Integer number = Integer.parseInt(input);
		Integer[] parsed = new Integer[length];
		for (int i = 0; i < length; ++i) {
			parsed[length - 1 - i] = number % 10;
			number /= 10;
		}
		return parsed;
	}
}
