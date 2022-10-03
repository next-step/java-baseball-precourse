package baseball.util;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberUtils {

	public static List<Integer> generateNoneDuplicatedNumberList(int minNo, int maxNo, int count) {
		List<Integer> numbers = new ArrayList<>();
		while (numbers.size() < count) {
			int random = Randoms.pickNumberInRange(minNo, maxNo);
			if (!numbers.contains(random)) {
				numbers.add(random);
			}
		}
		return numbers;
	}
}
