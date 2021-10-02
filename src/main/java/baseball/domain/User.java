package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import baseball.config.ConfigBaseball;
import nextstep.utils.Console;

/**
 * 사용자의 입력기능, 입력값 오류검증을 위한 도메인
 */
public class User {

	private List input = new ArrayList<Integer>();
	private List numberList = Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9');
	private boolean isInputted = false;
	private final String READLINE_MESSAGE = ConfigBaseball.READLINE_MESSAGE;
	private final String ERROR_MESSAGE = ConfigBaseball.ERROR_MESSAGE;
	private final int INPUT_SIZE = ConfigBaseball.INPUT_SIZE;

	public List getClearInputReadLine() {
		clear();
		while (!isInputted) {
			isInputted = inputNumber();
		}

		return getInput();
	}

	private boolean inputNumber() {
		String readLine = getReadLine();

		if (!validateReadLine(readLine)) {
			return false;
		}

		for (int i = 0; input.size() != INPUT_SIZE; i++) {
			input.add(Integer.parseInt(String.valueOf(readLine.charAt(i))));
		}
		return true;
	}

	private String getReadLine() {
		System.out.print(READLINE_MESSAGE);
		String readLine = Console.readLine();
		return readLine;
	}

	/**
	 * 입력한 값의 길이, 타입 체크
	 */
	private boolean validateReadLine(String readLine) {
		if (!validateLength(readLine)) {
			return false;
		}

		if (!validateType(readLine)) {
			return false;
		}

		return true;
	}

	private boolean validateType(String readLine) {
		int validateCount = 0;
		boolean validateResult = true;
		while (isValidatedType(validateResult, validateCount)) {
			validateResult = validateTypeInt(readLine, validateCount);
			validateCount++;
		}
		return validateResult;
	}

	/**
	 * 입력한 값이 입력길이 동안 타입검증을 통과하는지 확인
	 */
	private boolean isValidatedType(boolean validateResult, int validateCount) {
		return validateResult && validateCount != INPUT_SIZE;
	}

	/**
	 * 입력한 값이 숫자가 아닐 경우 [ERROR]메시지 출력
	 */
	private boolean validateTypeInt(String readLine, int index) {
		if (!numberList.contains(readLine.charAt(index))) {
			printErrorMessage();
			return false;
		}
		return true;
	}

	/**
	 * 입력한 값의 길이가 INPUT_SIZE 가 아닐 경우 [ERROR]메시지 출력
	 */
	private boolean validateLength(String readLine) {
		if (readLine.length() != INPUT_SIZE) {
			printErrorMessage();
			return false;
		}
		return true;
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

	public List getInput() {
		return input;
	}
}
