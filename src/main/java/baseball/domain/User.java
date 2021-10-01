package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import baseball.config.ConfigBaseball;
import nextstep.utils.Console;

public class User {

	private List input = new ArrayList<Integer>();
	private List numberList = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
	private boolean isInputted = false;
	private final String ERROR_MESSAGE = ConfigBaseball.ERROR_MESSAGE;
	private final int INPUT_SIZE = ConfigBaseball.INPUT_SIZE;

	public List getInput() {
		clear();
		while (!isInputted) {
			isInputted = inputNumber();
		}

		return input;
	}

	private boolean inputNumber() {
		System.out.print("숫자를 입력해주세요 : ");
		String readLine = Console.readLine();

		boolean isValidated = validateReadLine(readLine);
		if (!isValidated) {
			return false;
		}

		for (int i = 0; input.size() != INPUT_SIZE; i++) {
			int parseInt = Integer.parseInt(String.valueOf(readLine.charAt(i)));
			input.add(parseInt);
		}
		return true;
	}

	/**
	 * 입력한 값의 크기, 타입 체크
	 */
	private boolean validateReadLine(String readLine) {
		if (validateLength(readLine)) {
			return false;
		}

		int validateTypeCount = 0;
		boolean validateTypeResult = true;
		while (isValidatedType(validateTypeResult, validateTypeCount)) {
			validateTypeResult = !validateType(readLine, validateTypeCount);
			validateTypeCount++;
		}

		return validateTypeResult;
	}

	private boolean isValidatedType(boolean validateTypeResult, int validateTypeCount) {
		return validateTypeResult && validateTypeCount != INPUT_SIZE;
	}

	/**
	 * 입력한 값이 숫자가 아닐 경우 [ERROR]메시지 출력
	 */
	private boolean validateType(String readLine, int index) {
		String value = String.valueOf(readLine.charAt(index));

		if (!numberList.contains(value)) {
			printErrorMessage();
			return true;
		}
		return false;
	}

	/**
	 * 입력한 값의 크기가 3이 아닐 경우 [ERROR]메시지 출력
	 */
	private boolean validateLength(String readLine) {
		if (readLine.length() != INPUT_SIZE) {
			printErrorMessage();
			return true;
		}
		return false;
	}

	private void printErrorMessage() {
		System.out.println(ERROR_MESSAGE);
	}

	private void clear() {
		if (!input.isEmpty()) {
			input.clear();
		}

		isInputted = false;
	}

}
