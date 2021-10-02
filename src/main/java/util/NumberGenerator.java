package util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nextstep.utils.Randoms;

public class NumberGenerator {

	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;

	public static List<Integer> createNumber() {

		int cnt = 0;
		Set<Integer> set = new HashSet<>();

		while (cnt < 3) {
			if (set.add(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER))) {
				cnt++;
			}
		}
		return new ArrayList<>(set);
	}

	public static List<Integer> convertInput(String input) {
		List<Integer> numbers = new ArrayList<>();
		for (char c : input.toCharArray()) {
			numbers.add(Integer.valueOf(String.valueOf(c)));
		}
		return numbers;
	}
}
