package baseball.controller;

import baseball.common.NumberOption;
import baseball.domain.BaseballNumber;
import baseball.domain.GameResult;

public class GameRule {

	private GameResult gameResult;
	private final BaseballNumber playerNumber;
	private final BaseballNumber computerNumber;

	public GameRule(BaseballNumber playerNumber, BaseballNumber computerNumber) {
		this.playerNumber = playerNumber;
		this.computerNumber = computerNumber;
		checkResult();
	}

	public GameResult getResult() {
		return this.gameResult;
	}

	private void checkResult() {
		gameResult = new GameResult();
		for (int idx = 0; idx < NumberOption.MAX_SIZE.getValue(); idx++) {
			checkStrike(idx);
			checkBall(idx);
		}
	}

	private void checkStrike(int idx) {
		if (this.playerNumber.getValueByIndex(idx) == this.computerNumber.getValueByIndex(idx)) {
			this.gameResult.addStrike();
		}
	}

	private void checkBall(int idx) {
		checkBallAfterIdx(idx);
		checkBallBeforeIdx(idx);
	}

	private void checkBallAfterIdx(int idx) {
		int afterIdx = getAfterIdx(idx);
		if (this.playerNumber.getValueByIndex(idx) == this.computerNumber.getValueByIndex(afterIdx)) {
			this.gameResult.addBall();
		}
	}

	private void checkBallBeforeIdx(int idx) {
		int beforeIdx = getBeforeIdx(idx);
		if (this.playerNumber.getValueByIndex(idx) == this.computerNumber.getValueByIndex(beforeIdx)) {
			this.gameResult.addBall();
		}
	}

	private int getAfterIdx(int idx) {
		int afterIdx = idx + 1;
		if (NumberOption.MAX_SIZE.isEqualValue(afterIdx)) {
			afterIdx = NumberOption.ZERO.getValue();
		}
		return afterIdx;
	}

	private int getBeforeIdx(int idx) {
		int beforeIdx = idx - 1;
		if (beforeIdx < NumberOption.ZERO.getValue()) {
			beforeIdx = NumberOption.MAX_SIZE.getValue() - 1;
		}
		return beforeIdx;
	}
}
