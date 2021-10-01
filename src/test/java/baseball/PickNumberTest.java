package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import baseball.utils.PickNumber;

public class PickNumberTest {
	@Test
	void 자리수숫자() {
		assertThat(PickNumber.getDigitNumber(951, 2)).isEqualTo(5);
	}

	@Test
	void 자리수확인() {
		assertThat(PickNumber.validateNumberOfDigit(2, 3)).isFalse();
		assertThat(PickNumber.validateNumberOfDigit(21, 3)).isFalse();
		assertThat(PickNumber.validateNumberOfDigit(326, 3)).isTrue();
		assertThat(PickNumber.validateNumberOfDigit(2143, 3)).isFalse();
	}

	@Test
	void 서로다른숫자() {
		assertThat(PickNumber.validateDigitNumberDistinct(423, 3, 2)).isTrue();
		assertThat(PickNumber.validateDigitNumberDistinct(422, 2, 1)).isFalse();
	}
}
