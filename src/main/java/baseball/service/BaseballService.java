package baseball.service;

import java.util.HashMap;

import baseball.utils.NumberForBaseball;
import nextstep.utils.Randoms;

public class BaseballService {
	private int answer;
	private HashMap<String, Integer> result;

	public BaseballService() {
		answer = Randoms.pickNumberInRange(100, 999);
		initiateResult();
	}

	public int createAnswer() {
		while (NumberForBaseball.hasDuplicateDigits(answer)) {
			answer = Randoms.pickNumberInRange(100, 999);
		}
		System.out.println("정답: " + answer);
		return answer;
	}

	public boolean isValidInput(String input) {
		return !NumberForBaseball.hasDuplicateDigits(Integer.parseInt(input));
	}

	public HashMap<String, Integer> returnResult(String input) {
		initiateResult();
		char[] inputNumbers = NumberForBaseball.getDigitsArray(Integer.parseInt(input));
		char[] answerNumbers = NumberForBaseball.getDigitsArray(answer);
		for (int i = 0; i < NumberForBaseball.NUMBER_OF_DIGITS_FOR_BASEBALL; i++) {
			checkNumber(inputNumbers[i], i, 0, answerNumbers);
		}
		return result;
	}

	private void initiateResult() {
		result = new HashMap<>();
		result.put("ball", 0);
		result.put("strike", 0);
	}

	private void checkNumber(char inputNumber, int inputNumberIndex, int answerNumberIndex, char[] answerNumbers) {
		if (answerNumberIndex == NumberForBaseball.NUMBER_OF_DIGITS_FOR_BASEBALL) {
			return;
		}
		if (inputNumber == answerNumbers[answerNumberIndex]) {
			checkBallOrStrike(inputNumber, inputNumberIndex, answerNumbers);
			return;
		}
		checkNumber(inputNumber, inputNumberIndex, answerNumberIndex + 1, answerNumbers);
	}

	private void checkBallOrStrike(char inputNumber, int index, char[] answerNumbers) {
		if (inputNumber == answerNumbers[index]) {
			result.put("strike", result.get("strike") + 1);
			return;
		}
		result.put("ball", result.get("ball") + 1);
	}
}
