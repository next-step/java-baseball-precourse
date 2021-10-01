package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nextstep.utils.Randoms;

public class Computer {
	private Set randomSet = new HashSet<Integer>();
	private List input = new ArrayList();

	public Computer() {
		while (randomSet.size() != 3) {
			int random = Randoms.pickNumberInRange(1, 9);
			randomSet.add(random);
		}

		for (Object o : randomSet) {
			input.add(o);
		}
	}

	public List getInput() {
		return input;
	}
}
