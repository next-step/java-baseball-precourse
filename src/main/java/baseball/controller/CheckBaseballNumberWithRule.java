package baseball.controller;

import java.util.List;

import baseball.model.ConstValue;
import baseball.model.OpponentBaseballNumber;
import baseball.model.PlayerBaseballNumber;

public class CheckBaseballNumberWithRule {

	public static void checkBaseballNumber(OpponentBaseballNumber opponentBaseballNumber,
		PlayerBaseballNumber playerBaseballNumber) {

		for(int i=0; i< ConstValue.BASEBALL_SIZE; i++) {
			checkStrike(opponentBaseballNumber, playerBaseballNumber, i);
			checkBall(opponentBaseballNumber, playerBaseballNumber, i);
		}
	};

	private static void checkStrike(OpponentBaseballNumber opponentBaseballNumber,
		PlayerBaseballNumber playerBaseballNumber, int index) {
		List<Integer> playerNumberList = playerBaseballNumber.getBaseballNumbers();
		List<Integer> opponentNumberList = opponentBaseballNumber.getBaseballNumbers();

		if(opponentNumberList.get(index).equals(playerNumberList.get(index)))
			playerBaseballNumber.setStrikeCount(playerBaseballNumber.getStrikeCount()+1);

	};

	private static void checkBall(OpponentBaseballNumber opponentBaseballNumber,
		PlayerBaseballNumber playerBaseballNumber, int index) {
		List<Integer> playerNumberList = playerBaseballNumber.getBaseballNumbers();
		List<Integer> opponentNumberList = opponentBaseballNumber.getBaseballNumbers();

		if (opponentNumberList.contains(playerNumberList.get(index))
			&& !opponentNumberList.get(index).equals(playerNumberList.get(index))) {
			playerBaseballNumber.setBallCount(playerBaseballNumber.getBallCount()+1);
		}

	};
}
