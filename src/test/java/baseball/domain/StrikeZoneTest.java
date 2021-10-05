package baseball.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StrikeZoneTest {
	@Test
	@DisplayName("같은 숫자가 존재하는지, 자릿수가 같은지 여부에 따라 값을 반환한다.")
	void of() {
		// then
		assertAll(
			() -> assertThat(StrikeZone.of(true, true))
				.isEqualTo(StrikeZone.STRIKE),
			() -> assertThat(StrikeZone.of(true, false))
				.isEqualTo(StrikeZone.BALL),
			() -> assertThat(StrikeZone.of(false, false))
				.isEqualTo(StrikeZone.NOTHING)
		);
	}
}