package baseball.domain;

import nextstep.utils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;

public class Computer {

	public final static int BALL_COUNT_LENGTH = 3;
	private Integer[] fullCount;

	public Computer() {
		this.fullCount = new Integer[BALL_COUNT_LENGTH];
		generateFullCount();
	}

	public Integer[] getFullCount() {
		return fullCount;
	}

	private void generateFullCount() {
		Set<Integer> fullCountSet = new LinkedHashSet();
		while (fullCountSet.size() != BALL_COUNT_LENGTH)
			fullCountSet.add(Randoms.pickNumberInRange(1, 9));
		fullCountSet.toArray(this.fullCount);
	}

}
