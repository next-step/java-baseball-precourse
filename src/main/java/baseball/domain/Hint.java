package baseball.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public class Hint {
	public static final int DEFAULT_COUNT = 0;

	private final Map<StrikeZone, Integer> values;

	public Hint(Map<StrikeZone, Integer> values) {
		this.values = Collections.unmodifiableMap(values);
	}

	public static Hint create() {
		return new Hint(createDefaultStrikeZoneMap());
	}

	public Hint hit(StrikeZone strikeZone) {
		int count = getCount(strikeZone);

		Map<StrikeZone, Integer> copiedMap = new EnumMap<>(values);
		copiedMap.put(strikeZone, ++count);
		return new Hint(copiedMap);
	}

	public int getCount(StrikeZone strikeZone) {
		return values.getOrDefault(strikeZone, DEFAULT_COUNT);
	}

	public boolean isStrikeOut() {
		return values.get(StrikeZone.STRIKE) == Numbers.IMMUTABLE_SIZE;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Hint hint = (Hint)o;
		return Objects.equals(values, hint.values);
	}

	@Override
	public int hashCode() {
		return Objects.hash(values);
	}

	private static Map<StrikeZone, Integer> createDefaultStrikeZoneMap() {
		Map<StrikeZone, Integer> values = new EnumMap<>(StrikeZone.class);
		for (StrikeZone strikeZone : StrikeZone.values()) {
			values.put(strikeZone, DEFAULT_COUNT);
		}
		return values;
	}
}
