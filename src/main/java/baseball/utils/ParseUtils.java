package baseball.utils;

import java.util.ArrayList;
import java.util.List;

public class ParseUtils {

	/**
	 * 1-9 사이의 숫자로만 이뤄진 input String 을 List<Integer> 로 반환한다.
	 *
	 * @param input 1-9 사이로 이루어진 String
	 * @return 1-9 사이의 원소들로 이루어진 List
	 */
	public static List<Integer> toIntList(String input) {
		final List<Integer> result = new ArrayList<>();

		for (int i = 0; i < input.length(); i++) {
			result.add(ConvertUtils.charToInt(input.charAt(i)));
		}

		return result;
	}
}
