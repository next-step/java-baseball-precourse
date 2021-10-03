package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nextstep.utils.Randoms;

public class NumberGenerator {

	private static final int MAX_DIGITS = 3;
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;

	public static List<Integer> createNumber() {

		Set<Integer> set = new HashSet<>();

		while (set.size() < MAX_DIGITS) {
			set.add(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
		}

		return new ArrayList<Integer>(set);
	}

}
