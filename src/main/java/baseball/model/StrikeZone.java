package baseball.model;

import java.util.Iterator;
import java.util.List;

import baseball.utils.CollectionUtils;

public enum StrikeZone {
	STRIKE(true, true),
	BALL(true),
	NOTHING;

	private final boolean existsNumber;
	private final boolean sameDigit;

	StrikeZone() {
		this(false, false);
	}

	StrikeZone(boolean existsNumber) {
		this(existsNumber, false);
	}

	StrikeZone(boolean existsNumber, boolean sameDigit) {
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
