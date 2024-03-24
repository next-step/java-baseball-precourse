package gameLogics;

import dto.State;

import java.util.List;

public class InningSequence {
	public static boolean checkEndState(State state) {
		if (state.getStrike() == BaseRule.GAME_NUMBER_LENGTH) {
			return true;
		}
		return false;
	}

	public static void playInning(List<Integer> answer, List<Integer> pitch, State currentState) {
		int index = -1;
		int strikeCount = 0;
		int ballCount = 0;
		while (++index < BaseRule.GAME_NUMBER_LENGTH) {
			if (answer.get(index) == pitch.get(index)) {
				strikeCount += 1;
				continue;
			}
			if (answer.contains(pitch.get(index)))
				ballCount += 1;
		}
		currentState.adjustState(strikeCount, ballCount);
	}
}
