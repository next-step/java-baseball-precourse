package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

import nextstep.utils.Randoms;

public class BaseballNumbersGenerator {
	private static final Pattern THREE_NUMERIC_VALIDATION_PATTERN = Pattern.compile("[1-9]{3}");
	private static final int NUMBER_SIZE = 3;
	private static final int NUMBER_RANGE_MIN = 1;
	private static final int NUMBER_RANGE_MAX = 9;
	private static final String EMPTY_VALUE = "";
	private static final String BLANK_VALUE = "\\s";

	public static BaseballNumbers createBaseballNumbers() {
		List<Integer> randomNumbers = new ArrayList<>();

		while (randomNumbers.size() < NUMBER_SIZE) {
			initializeWithoutDuplication(randomNumbers);
		}
		return new BaseballNumbers(randomNumbers);
	}

	private static void initializeWithoutDuplication(List<Integer> randomNumbers) {
		int number = Randoms.pickNumberInRange(NUMBER_RANGE_MIN, NUMBER_RANGE_MAX);
		if (!randomNumbers.contains(number)) {
			randomNumbers.add(number);
		}
	}

	public static BaseballNumbers createBaseballNumbers(String inputValue) {
		checkThreeNumeric(inputValue);
		List<Integer> inputNumbers = generateNumberList(splitValues(inputValue));
		checkDuplicate(inputNumbers);
		return new BaseballNumbers(inputNumbers);
	}

	private static String[] splitValues(String inputValue) {
		return inputValue.replaceAll(BLANK_VALUE, EMPTY_VALUE)
			.split(EMPTY_VALUE);
	}

	private static List<Integer> generateNumberList(String[] splitValues) {
		List<Integer> numbers = new ArrayList<>();
		for (String number : splitValues) {
			numbers.add(Integer.parseInt(number));
		}
		return numbers;
	}

	private static void checkDuplicate(List<Integer> baseballNumbers) {
		int inputSize = baseballNumbers.size();
		int deduplicatedSize = new HashSet<>(baseballNumbers).size();

		if (deduplicatedSize != inputSize) {
			throw new IllegalArgumentException("입력 된 숫자에 중복이 있으면 안됩니다.");
		}
	}

	private static void checkThreeNumeric(String inputValue) {
		boolean isThreeNumeric = THREE_NUMERIC_VALIDATION_PATTERN.matcher(inputValue).matches();
		if (!isThreeNumeric) {
			throw new IllegalArgumentException("3개의 숫자(1~9)를 입력 하세요.");
		}
	}
}
