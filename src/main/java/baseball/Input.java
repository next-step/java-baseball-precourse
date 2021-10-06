package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

import nextstep.utils.Console;

public class Input {
	private static final Pattern THREE_NUMERIC_VALIDATION_PATTERN = Pattern.compile("[1-9]{3}");
	private static final String EMPTY_VALUE = "";
	private static final String BLANK_VALUE = "\\s";

	public static BaseballNumbers readPlayerBaseballNumbers() {
		String inputValue = Console.readLine();
		isThreeNumeric(inputValue);

		List<Integer> inputNumbers = generateNumberList(splitValues(inputValue));
		checkDuplicate(inputNumbers);

		return new BaseballNumbers(inputNumbers);
	}

	private static void checkDuplicate(List<Integer> inputNumbers){
		int inputSize = inputNumbers.size();
		int deduplicatedSize = new HashSet<>(inputNumbers).size();

		if(deduplicatedSize != inputSize){
			throw new IllegalArgumentException("입력 된 숫자에 중복이 있으면 안됩니다.");
		}
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

	private static void isThreeNumeric(String inputValue) {
		boolean isThreeNumeric = THREE_NUMERIC_VALIDATION_PATTERN.matcher(inputValue).matches();
		if (!isThreeNumeric) {
			throw new IllegalArgumentException("3개의 숫자(1~9)를 입력 하세요.");
		}
	}
}
