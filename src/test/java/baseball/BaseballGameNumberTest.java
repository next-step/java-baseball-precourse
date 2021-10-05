package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import baseball.utils.BaseballGameNumber;

public class BaseballGameNumberTest {
	@Test
	void 자리수숫자() {
		assertThat(BaseballGameNumber.getDigitNumber(951, 2)).isEqualTo(5);
	}

	@Test
	void 자리수확인() {
		assertThat(BaseballGameNumber.validateNumberOfDigit(2, 3)).isFalse();
		assertThat(BaseballGameNumber.validateNumberOfDigit(21, 3)).isFalse();
		assertThat(BaseballGameNumber.validateNumberOfDigit(326, 3)).isTrue();
		assertThat(BaseballGameNumber.validateNumberOfDigit(2143, 3)).isFalse();
	}

	@Test
	void 서로다른숫자() {
		assertThat(BaseballGameNumber.validateDigitNumberDistinct(423, 3, 2)).isTrue();
		assertThat(BaseballGameNumber.validateDigitNumberDistinct(422, 2, 1)).isFalse();
	}

	@Test
	void 서로다른3자리숫자() {
		assertThat(BaseballGameNumber.validatePickNumber(123)).isTrue();
		assertThat(BaseballGameNumber.validatePickNumber(223)).isFalse();
		assertThat(BaseballGameNumber.validatePickNumber(333)).isFalse();
		assertThat(BaseballGameNumber.validatePickNumber(1234)).isFalse();
		assertThat(BaseballGameNumber.validatePickNumber(34)).isFalse();
	}

	@Test
	void 스트라이크개수() {
		assertThat(BaseballGameNumber.getStrikeCount(123, 123)).isEqualTo(3);
		assertThat(BaseballGameNumber.getStrikeCount(123, 122)).isEqualTo(2);
		assertThat(BaseballGameNumber.getStrikeCount(123, 132)).isEqualTo(1);
		assertThat(BaseballGameNumber.getStrikeCount(123, 312)).isEqualTo(0);
	}

	@Test
	void 볼개수() {
		assertThat(BaseballGameNumber.getBallCount(123, 123)).isEqualTo(0);
		assertThat(BaseballGameNumber.getBallCount(123, 254)).isEqualTo(1);
		assertThat(BaseballGameNumber.getBallCount(123, 132)).isEqualTo(2);
		assertThat(BaseballGameNumber.getBallCount(123, 312)).isEqualTo(3);
	}
}
