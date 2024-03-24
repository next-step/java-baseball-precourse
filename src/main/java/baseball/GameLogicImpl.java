package baseball;

import java.util.ArrayList;
import java.util.Collections;

import baseball.dto.MatchResult;
import baseball.dto.Numbers;

public class GameLogicImpl implements GameLogic {

	public Numbers createRandomNumbers() {
		return new Numbers();
	}

	public Numbers createNumbersFromUserInput(int userInput) {
		ArrayList<Integer> userInputArray = new ArrayList<Integer>();

		for (int i = 0; i < 3; i++) {
			userInputArray.add(userInput % 10);
			userInput /= 10;
		}

		Collections.reverse(userInputArray);
		return new Numbers(userInputArray);
	}

	public MatchResult matchNumbers(Numbers randomNumber, Numbers userInput) {
		MatchResult matchResult = new MatchResult();

		for (int i = 0; i < 3; i++) {
			if (isStrike(randomNumber.numbers.get(i), userInput.numbers.get(i))) {
				matchResult.strike++;
				continue;
			}

			if (isBall(randomNumber.numbers.get(i), userInput.numbers)) {
				matchResult.ball++;
			}
		}

		return matchResult;
	}

	private boolean isStrike(Integer randomNumber, Integer userInput) {
		return randomNumber.equals(userInput);
	}

	private boolean isBall(Integer num, ArrayList<Integer> userInput) {
		for (Integer input : userInput) {
			if (num.equals(input)) {
				return true;
			}
		}
		return false;
	}
}
