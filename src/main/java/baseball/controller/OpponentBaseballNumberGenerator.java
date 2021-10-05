package baseball.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import baseball.model.ConstValue;
import nextstep.utils.Randoms;

public class OpponentBaseballNumberGenerator {

	public List<Integer> generateOpponentBaseBallNumber() {
		HashSet<Integer> opponentBaseballNumbers = new HashSet<>();

		while(opponentBaseballNumbers.size() < ConstValue.BASEBALL_SIZE) {
			opponentBaseballNumbers.add(
				Randoms.pickNumberInRange(
					ConstValue.BASEBALL_MIN_NUMBER,
					ConstValue.BASEBALL_MAX_NUMBER)
			);
		}

		return new ArrayList<>(opponentBaseballNumbers);
	};
}
