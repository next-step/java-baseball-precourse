package baseball.service;

import static nextstep.utils.Randoms.*;

public class AnswerMaker {

	public static String make() {
		return make("");
	}

	private static String make(String answer) {
		if (answer.length() == 3) {
			return answer;
		}

		String newNumber = Integer.toString(pickNumberInRange(1, 9));
		while (answer.contains(newNumber)) {
			newNumber = Integer.toString(pickNumberInRange(1, 9));
			;
		}
		answer += newNumber;
		return make(answer);
	}

	public static boolean isValid(String answer) {
		return answer.matches("^(?!.*(.).*\\1)[1-9]{3}$");
	}
}
