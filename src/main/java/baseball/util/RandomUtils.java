package baseball.util;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Randoms;

public class RandomUtils {

	/**
	 * 1 ~ 9 까지의 범위의 숫자를 랜덤하게 생성하되, 겹치는 숫자가 없도록 3개 생성
	 *
	 * @return 지정한 범위 내의 숫자들이 겹치지 않은 상태로 들어있는 List
	 */
	public static List<Integer> generateNoDuplicateThreeBaseball() {
		final List<Integer> numbers = new ArrayList<>();

		while (numbers.size() < 3) {
			addIfNotDuplicated(numbers);
		}

		return numbers;
	}

	private static void addIfNotDuplicated(List<Integer> numbers) {
		final int random = Randoms.pickNumberInRange(1, 9);

		if (!numbers.contains(random)) {
			numbers.add(random);
		}
	}
}
