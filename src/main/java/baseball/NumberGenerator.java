package baseball;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Randoms;

public class NumberGenerator {

	private static final int MAX_DIGITS = 3;
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;

	public static List<Integer> createNumber() {

		boolean[] already = new boolean[MAX_NUMBER + 1];
		List<Integer> result = new ArrayList<Integer>();

		for (int i = 0; i < MAX_DIGITS;) {

			int number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);

			if (!already[number]) {
				already[number] = true;
				result.add(number);
				i++;
			}
		}
		return result;
	}

}
