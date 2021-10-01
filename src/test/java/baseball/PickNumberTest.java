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

	@Test
	void 서로다른3자리숫자() {
		assertThat(PickNumber.validatePickNumber(123)).isTrue();
		assertThat(PickNumber.validatePickNumber(223)).isFalse();
		assertThat(PickNumber.validatePickNumber(333)).isFalse();
		assertThat(PickNumber.validatePickNumber(1234)).isFalse();
		assertThat(PickNumber.validatePickNumber(34)).isFalse();
	}

	@Test
	void 스트라이크개수() {
		assertThat(PickNumber.getStrikeCount(123, 123)).isEqualTo(3);
		assertThat(PickNumber.getStrikeCount(123, 122)).isEqualTo(2);
		assertThat(PickNumber.getStrikeCount(123, 132)).isEqualTo(1);
		assertThat(PickNumber.getStrikeCount(123, 312)).isEqualTo(0);
	}

	@Test
	void 볼개수() {
		assertThat(PickNumber.getBallCount(123, 123)).isEqualTo(0);
		assertThat(PickNumber.getBallCount(123, 254)).isEqualTo(1);
		assertThat(PickNumber.getBallCount(123, 132)).isEqualTo(2);
		assertThat(PickNumber.getBallCount(123, 312)).isEqualTo(3);
	}
}
