package baseball.service;

import java.util.HashMap;

import baseball.utils.NumberForBaseball;
import nextstep.utils.Randoms;

public class BaseballService {
	private int answer;
	private HashMap<String, Integer> result;

	public BaseballService() {
		this.answer = Randoms.pickNumberInRange(100, 999);
		initiateResult();
	}

	public int createAnswer() {
		while (NumberForBaseball.hasDuplicateDigits(this.answer)) {
			this.answer = Randoms.pickNumberInRange(100, 999);
		}
		return this.answer;
	}

	public boolean isValidInput(String input) {
		return !NumberForBaseball.hasDuplicateDigits(Integer.parseInt(input));
	}

	public HashMap<String, Integer> returnResult(String input) {
		initiateResult();
		char[] inputNumbers = NumberForBaseball.getDigitsArray(Integer.parseInt(input));
		char[] answerNumbers = NumberForBaseball.getDigitsArray(this.answer);
		for (int i = 0; i < NumberForBaseball.NUMBER_OF_DIGITS_FOR_BASEBALL; i++) {
			checkNumber(inputNumbers[i], i, 0, answerNumbers);
		}
		return this.result;
	}

	private void initiateResult() {
		this.result = new HashMap<>();
		this.result.put("ball", 0);
		this.result.put("strike", 0);
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
			this.result.put("strike", this.result.get("strike") + 1);
			return;
		}
		this.result.put("ball", this.result.get("ball") + 1);
	}
}
