package baseball.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {
	Validator validator = new Validator();
	@DisplayName("1 ~ 9 이외의 숫자 입력")
	@Test
	public void 숫자_범위() {
		String userNumber = "101";
		assertThatThrownBy(() -> validator.checkUserInputNum(userNumber, 3, 1, 9))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("세자리 숫자 이외의 숫자 입력")
	@Test
	public void 숫자_길이() {
		String userNumber = "1234";
		assertThatThrownBy(() -> validator.checkUserInputNum(userNumber, 3, 1, 9))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("숫자 외 입력")
	@Test
	public void 숫자_외_문자() {
		String userNumber = "abc";
		assertThatThrownBy(() -> validator.checkUserInputNum(userNumber, 3, 1, 9))
			.isInstanceOf(IllegalArgumentException.class);
	}
}