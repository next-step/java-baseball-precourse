package baseball.service;

import baseball.model.Game;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberService {

	public void resetGame() {
		Game game = Game.getInstance();
		int value1 = Randoms.pickNumberInRange(1, 9);
		int value2 = Randoms.pickNumberInRange(1, 9);
		int value3 = Randoms.pickNumberInRange(1, 9);

		while (value1 == value2 || value2 == value3 || value3 == value1) {
			value1 = Randoms.pickNumberInRange(1, 9);
			value2 = Randoms.pickNumberInRange(1, 9);
			value3 = Randoms.pickNumberInRange(1, 9);
		}

		String goal = String.valueOf(value1) + value2 + value3;
		game.setGoal(goal);
	}

	public String getGameGoal() {
		Game game = Game.getInstance();
		return game.getGoal();
	}

	public boolean isStrike(int index, int value) {
		String goal = this.getGameGoal();
		Integer goalNum = Integer.valueOf(goal.substring(index, index + 1));
		if (value == goalNum) {
			return true;
		}
		return false;
	}

	public boolean isBall(int value) { //ball은 strike가 아닐때만 호출하자
		boolean ball = false;
		for (int i = 0; i < 3; i++) { //자릿수
			ball = ball || isStrike(i, value);
		}
		return ball;
	}
}

