package validator;

import model.Answer;

public class InputValidator {
	public static String RESTART_CODE = "1";
	public static String END_CODE = "2";
	public static int CODE_LENGTH = 1;
	public static void validateAnswerInput(String input) throws IllegalArgumentException {
		if (input.length()!= Answer.ANSWER_LENGTH) {
			throw new IllegalArgumentException("3자리로 입력해주세요.");
		}

		for (int i = 0; i < Answer.ANSWER_LENGTH; i++) {
			if (input.charAt(i)< (char)(Answer.MIN_NUMBER + '0') || input.charAt(i) > (char)(Answer.MAX_NUMBER + '0')) {
				throw new IllegalArgumentException("각 자리의 숫자는 1~9 사이여야합니다.");
			}
		}

		if (input.charAt(0) == input.charAt(1) || input.charAt(0) == input.charAt(2) || input.charAt(1) == input.charAt(2)) {
			throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
		}
	}

	public static void validateRestartInput(String input) throws IllegalArgumentException {
		if (input.length()!=CODE_LENGTH || (!input.equals(RESTART_CODE) && !input.equals(END_CODE))) {
			throw new IllegalArgumentException("1과 2중 하나의 숫자를 입력해주세요.");
		}
	}
}
