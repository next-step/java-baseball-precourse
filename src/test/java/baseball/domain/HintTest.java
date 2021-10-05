package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.EnumMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HintTest {
	@Test
	@DisplayName("StrikeZone의 갯수를 관리하는 Hint 클래스 생성")
	void create() {
		// given
		Map<StrikeZone, Integer> zoneMap = new EnumMap<>(StrikeZone.class);
		zoneMap.put(StrikeZone.STRIKE, Hint.DEFAULT_COUNT);
		zoneMap.put(StrikeZone.BALL, Hint.DEFAULT_COUNT);
		zoneMap.put(StrikeZone.NOTHING, Hint.DEFAULT_COUNT);

		// when
		Hint actual = new Hint(zoneMap);

		// then
		assertThat(actual)
			.isEqualTo(Hint.create());
	}

	@Test
	@DisplayName("지정한 StrikeZone의 갯수가 증가되는지")
	void hit() {
		// given
		Hint hint = Hint.create();

		// when
		StrikeZone strike = StrikeZone.STRIKE;
		hint = hint.hit(strike);
		hint = hint.hit(strike);
		hint = hint.hit(StrikeZone.NOTHING);

		// then
		Map<StrikeZone, Integer> zoneEnumMap = new EnumMap<>(StrikeZone.class);
		zoneEnumMap.put(strike, 2);
		zoneEnumMap.put(StrikeZone.BALL, Hint.DEFAULT_COUNT);
		zoneEnumMap.put(StrikeZone.NOTHING, 1);
		assertThat(hint)
			.isEqualTo(new Hint(zoneEnumMap));
	}
}