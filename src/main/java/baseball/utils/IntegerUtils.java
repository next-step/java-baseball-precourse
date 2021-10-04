package baseball.utils;

import java.util.ArrayList;
import java.util.List;

public final class IntegerUtils {
	private IntegerUtils() {
	}

	public static List<Integer> convertStringToIntegerList(String intString) {
		int length = intString.length();

		List<Integer> result = new ArrayList<>(length);
		for (int i = 0; i < length; i++) {
			char charAt = intString.charAt(i);
			result.add(convertCharToInt(charAt));
		}
		return result;
	}

	private static int convertCharToInt(char charAt) {
		return Character.getNumericValue(charAt);
	}
}
