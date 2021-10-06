package baseball.controller;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import baseball.model.ConstValue;
import nextstep.utils.Randoms;

public class OpponentBaseballNumberGenerator {

	public static List<Integer> generateOpponentBaseBallNumber() {
		LinkedHashSet<Integer> opponentBaseballNumbers = new LinkedHashSet<>();

		while (opponentBaseballNumbers.size() < ConstValue.BASEBALL_SIZE) {
			opponentBaseballNumbers.add(
				Randoms.pickNumberInRange(
					ConstValue.BASEBALL_MIN_NUMBER,
					ConstValue.BASEBALL_MAX_NUMBER)
			);
		}

		return new ArrayList<>(opponentBaseballNumbers);
	}

	;
}
