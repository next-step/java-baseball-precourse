package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

	/**
	 *  중복되지 않는 1~9까지의 숫자만 입력받음 만약,
	 *  잘못된 값 입력 시 [ERROR]메시지 출력 후 재입력 요청
	 */
	public List getClearInputReadLine() {
		clear();
		while (!isInputted) {
			isInputted = inputNumber();
		}

		return getInput();
	}

	/**
	 * 입력한 값의 길이, 타입, 중복입력에 대한 검증을 통과 할
	 * 경우에만 정상적인 값으로 인정받아 입력에 포함
	 */
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

	/**
	 * 콘솔로 사용자의 입력을 받음
	 * @return Console.readLine();
	 */
	private String getReadLine() {
		System.out.print(READLINE_MESSAGE);
		String readLine = Console.readLine();
		return readLine;
	}

	/**
	 * 입력한 값의 길이, 타입, 중복입력 체크
	 */
	private boolean validateReadLine(String readLine) {
		if (!validateLength(readLine) || !validateType(readLine) || !validateDuplication(readLine)) {
			return false;
		}

		return true;
	}

	/**
	 * 입력한 값 중에 두개이상 인 값이 있는지 체크
	 */
	private boolean validateDuplication(String readLine) {
		List dupCheckList = new ArrayList();

		int frequency = getFrequency(readLine, dupCheckList, 0);

		if (frequency > 1) {
			printErrorMessage();
			return false;
		}

		return true;
	}

	/**
	 * 입력한 값중에 가장 높은 빈도수 반환
	 */
	private int getFrequency(String readLine, List dupCheckList, int frequency) {
		for (int i = 0; i < INPUT_SIZE; i++) {
			dupCheckList.add(readLine.charAt(i));
			frequency = Math.max(Collections.frequency(dupCheckList, dupCheckList.get(i)), frequency);
		}

		return frequency;
	}

	/**
	 * 입력한 값이 입력길이 동안 타입검증을 통과하는지 확인
	 */
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
	 * 타입검증이 통과 되었고 입력길이에 도달했는지 확인
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

	/**
	 * System.out.println(ERROR_MESSAGE);
	 */
	private void printErrorMessage() {
		System.out.println(ERROR_MESSAGE);
	}

	/**
	 * input, isInputted 초기화
	 */
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
