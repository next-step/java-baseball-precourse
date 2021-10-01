package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import baseball.utils.PickNumber;

public class PickNumberTest {
	@Test
	void 자리수숫자() {
		assertThat(PickNumber.getDigitNumber(951, 2)).isEqualTo(5);
	}
}
