package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nextstep.utils.Randoms;

public class Computer {
	private Set randomSet = new HashSet<Integer>();
	private List randomValue = new ArrayList();

	public List getRandomValue() {
		clear();
		init();
		return randomValue;
	}

	private void init() {
		while (randomSet.size() != 3) {
			int random = Randoms.pickNumberInRange(1, 9);
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
