package baseball.service;

import baseball.utils.NumberForBaseball;
import nextstep.utils.Randoms;

public class BaseballService {
	private int answer;

	public BaseballService() {
		this.answer = Randoms.pickNumberInRange(100, 999);
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
}
