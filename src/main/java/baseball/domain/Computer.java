package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import baseball.config.ConfigBaseball;
import nextstep.utils.Randoms;

public class Computer {
	private Set randomSet = new HashSet<Integer>();
	private List randomValue = new ArrayList();
	private final int INPUT_SIZE = ConfigBaseball.INPUT_SIZE;
	private final int PICK_NUMBER_MIN = ConfigBaseball.PICK_NUMBER_MIN;
	private final int PICK_NUMBER_MAX = ConfigBaseball.PICK_NUMBER_MAX;

	public List getRandomValue() {
		clear();
		init();
		return randomValue;
	}

	private void init() {
		while (randomSet.size() != INPUT_SIZE) {
			int random = Randoms.pickNumberInRange(PICK_NUMBER_MIN, PICK_NUMBER_MAX);
			randomSet.add(random);
		}

		for (Object randomNumber : randomSet) {
			randomValue.add(randomNumber);
		}
	}

	private void clear() {
		if (!randomSet.isEmpty()) {
			randomSet.clear();
		}

		if (!randomValue.isEmpty()) {
			randomValue.clear();
		}
	}

}
