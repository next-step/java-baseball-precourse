package baseball.utils;

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
}

