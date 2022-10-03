package baseball.computer;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * @author garden.iee
 */
public class ComputerService {

	public List<Integer> getComputerOutput() {
		return pickUniqueNumbersInRange(1, 9, 3);
	}

	private List<Integer> pickUniqueNumbersInRange(int startInclusive, int endInclusive, int count) {
		return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
	}
}