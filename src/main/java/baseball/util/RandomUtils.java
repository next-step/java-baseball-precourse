package baseball.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nextstep.utils.Randoms;

public class RandomUtils {

	private static final int MINIMUM_RESULT_SIZE = 1;

	/**
	 * startInclusive ~ endInclusive 까지의 범위의 숫자를 랜덤하게 생성하되, 겹치는 숫자가 없도록 생성한다.
	 *
	 * @param startInclusive    범위의 시작값, 리턴 범위내에 포함된다.
	 * @param endInclusive        범위의 끝값, 리턴 범위내에 포함된다.
	 * @param resultSize        몇 개 짜리 겹치지않는 숫자를 반환할 것인지에 대한 값
	 *
	 * @return 지정한 범위 내의 숫자들이 겹치지 않은 상태로 들어있는 List
	 */
	public static List<Integer> generateNoDuplicateNumbers(final int startInclusive, final int endInclusive,
		final int resultSize) {
		validateResultSize(resultSize, endInclusive - startInclusive + 1);

		final Set<Integer> numbers = new HashSet<>();

		while (numbers.size() < resultSize) {
			numbers.add(Randoms.pickNumberInRange(startInclusive, endInclusive));
		}

		return new ArrayList<>(numbers);
	}

	private static void validateResultSize(int resultSize, int availableSize) {
		if (resultSize < MINIMUM_RESULT_SIZE) {
			throw new IllegalArgumentException("[ERROR] resultSize 는 1보다 작을 수 없습니다.");
		}
		if (availableSize < resultSize) {
			throw new IllegalArgumentException("[ERROR] 범위내의 모든숫자보다 resultSize 값이 클 수 없습니다.");
		}
	}
}
