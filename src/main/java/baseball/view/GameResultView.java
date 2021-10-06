package baseball.view;

import baseball.model.ConstValue;
import baseball.model.PlayerBaseballNumber;

public class GameResultView {

	public static void printGameRoundResult(PlayerBaseballNumber playerBaseballNumber) {
		System.out.println(generateGameMessage(playerBaseballNumber));

		if(playerBaseballNumber.getStrikeCount()==3)
			System.out.println(ConstValue.GAME_END);
	}

	private static String generateGameMessage(PlayerBaseballNumber playerBaseballNumber) {
		return generateStrikeCountMessgae(playerBaseballNumber) +
			generateBallCountMessage(playerBaseballNumber) +
			generateNothingMessgae(playerBaseballNumber);
	};

	private static String generateBallCountMessage(PlayerBaseballNumber playerBaseballNumber) {
		if(playerBaseballNumber.getBallCount() > 0)
			return Integer.toString(playerBaseballNumber.getBallCount()) +
				ConstValue.GAME_RULE_BALL;

		return "";
	};

	private static String generateStrikeCountMessgae(PlayerBaseballNumber playerBaseballNumber) {
		if(playerBaseballNumber.getStrikeCount() > 0)
			return Integer.toString(playerBaseballNumber.getStrikeCount()) +
				ConstValue.GAME_RULE_STRIKE;

		return "";
	};

	private static String generateNothingMessgae(PlayerBaseballNumber playerBaseballNumber) {
		if(playerBaseballNumber.getStrikeCount() == 0 &&
		playerBaseballNumber.getBallCount() == 0)
			return ConstValue.GAME_RULE_NOTHING;

		return "";
	};
}