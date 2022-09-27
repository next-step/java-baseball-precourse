package baseball.service;

import baseball.model.Game;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberService {

	public void resetGame() {
		Game game = Game.getInstance();
		int value1 = Randoms.pickNumberInRange(1, 9);
		int value2 = Randoms.pickNumberInRange(1, 9);
		int value3 = Randoms.pickNumberInRange(1, 9);

		String goal = String.valueOf(value1) + String.valueOf(value2) + String.valueOf(value3);
		game.setGoal(goal);
	}

	public String getGameGoal() {
		Game game = Game.getInstance();
		return game.getGoal();
	}


}

