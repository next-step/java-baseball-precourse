package baseball.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public final class CollectionUtils {
	private CollectionUtils() {
	}

	public static <T> boolean isEmpty(Collection<T> collection) {
		return collection == null || collection.isEmpty();
	}

	public static <T> boolean isUniqueElement(List<T> origin, T element) {
		if (isEmpty(origin)) {
			return true;
		}

		List<T> copy = new LinkedList<>();
		for (T e : origin) {
			copy.add(e);
		}
		copy.remove(element);

		return !copy.contains(element);
	}

	public static <T> List<T> listOf(T[] arrays) {
		return new ArrayList<>(Arrays.asList(arrays));
	}

	public static String joining(List<String> list, String separator) {
		StringBuilder sb = new StringBuilder();
		for (String str : list) {
			sb.append(str).append(separator);
		}
		int firstIndex = 0;
		return sb.length() == firstIndex ? sb.toString()
			: sb.substring(firstIndex, sb.length() - separator.length());
	}
}

