package baseball;

import static baseball.GameMessage.*;

import java.util.List;

/**
 * @author garden.iee
 */
public class HintService {

	private int ball;
	private int strike;

	public HintService(final int ball, final int strike) {
		this.ball = ball;
		this.strike = strike;
	}

	public HintService(List<Integer> userInput, List<Integer> computerOutput) {
		isSameDigit(userInput, computerOutput);
		isSamePosition(userInput, computerOutput);
	}

	public boolean isExistBall() {
		return this.ball > 0;
	}

	public boolean isExistStrike() {
		return this.strike > 0;
	}

	public boolean isThreeStrike() {
		return this.strike == 3;
	}

	private void isSameDigit(List<Integer> userInput, List<Integer> computerOutput) {
		for (Integer input : userInput) {
			countSameNumber(computerOutput, input);
		}
	}

	private void isSamePosition(List<Integer> userInput, List<Integer> computerOutput) {
		for (int i = 0; i < userInput.size(); i++) {
			countSamePosition(userInput, computerOutput, i);
		}
	}

	private void countSameNumber(List<Integer> computerOutput, Integer input) {
		if (computerOutput.contains(input)) {
			this.ball++;
		}
	}

	private void countSamePosition(List<Integer> userInput, List<Integer> computerOutput, int index) {
		if (userInput.get(index).equals(computerOutput.get(index))) {
			this.strike++;
			this.ball--;
		}
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(getString(isExistBall(), result, this.ball + BALL.getMessage()));
		result.append(getString(isExistBall() && isExistStrike(), result, " "));
		result.append(getString(isExistStrike(), result, this.strike + STRIKE.getMessage()));
		result.append(getString(!isExistBall() && !isExistStrike(), result, NOTHING.getMessage()));
		return result.toString();
	}

	private StringBuilder getString(boolean isExist, StringBuilder result, String hintToString) {
		if (isExist) {
			result.append(hintToString);
		}
		return result;
	}
}