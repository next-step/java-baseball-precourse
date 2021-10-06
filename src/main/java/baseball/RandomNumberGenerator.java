package baseball;

import java.util.HashSet;
import java.util.Set;

import nextstep.utils.Randoms;

public class RandomNumberGenerator {
	private static final int MIN = 1;
	private static final int MAX = 9;

	public static String generate() {
		Set<Integer> set = new HashSet<>();

		while (set.size() < 3) {
			set.add(Randoms.pickNumberInRange(MIN, MAX));
		}

		StringBuilder stringBuilder = new StringBuilder();
		set.forEach(stringBuilder::append);

		return stringBuilder.toString();
	}
}
