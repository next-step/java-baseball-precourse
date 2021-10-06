package baseball.domain;

import nextstep.utils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author theco2de
 * @version 1.0
 * @since 1.0
 */
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

	/**
	 * 임의의 서로 다른 3자리 수 주입
	 */
	private void generateFullCount() {
		Set<Integer> fullCountSet = new LinkedHashSet();
		while (fullCountSet.size() != BALL_COUNT_LENGTH)
			fullCountSet.add(Randoms.pickNumberInRange(1, 9));
		fullCountSet.toArray(this.fullCount);
	}

}
