package baseball.domain;

import java.util.Iterator;
import java.util.List;

import baseball.utils.CollectionUtils;

public enum StrikeZone {
	STRIKE("스트라이크", true, true),
	BALL("볼", true),
	NOTHING("낫싱");

	private final String name;
	private final boolean existsNumber;
	private final boolean sameDigit;

	StrikeZone(String name) {
		this(name, false, false);
	}

	StrikeZone(String name, boolean existsNumber) {
		this(name, existsNumber, false);
	}

	StrikeZone(String name, boolean existsNumber, boolean sameDigit) {
		this.name = name;
		this.existsNumber = existsNumber;
		this.sameDigit = sameDigit;
	}

	public static StrikeZone of(boolean existsNumber, boolean sameDigit) {
		List<StrikeZone> list = CollectionUtils.listOf(StrikeZone.values());
		Iterator<StrikeZone> iterator = list.iterator();

		while (iterator.hasNext()) {
			StrikeZone strikeZone = iterator.next();
			removeIfNotExists(iterator, strikeZone, existsNumber, sameDigit);
		}
		return list.get(0);
	}

	public String getName() {
		return name;
	}

	private static void removeIfNotExists(Iterator<StrikeZone> iterator, StrikeZone strikeZone,
		boolean existNumber, boolean sameDigit) {
		if (!strikeZone.equalsOf(existNumber, sameDigit)) {
			iterator.remove();
		}
	}

	private boolean equalsOf(boolean existNumber, boolean sameDigit) {
		return this.existsNumber == existNumber && this.sameDigit == sameDigit;
	}
}
