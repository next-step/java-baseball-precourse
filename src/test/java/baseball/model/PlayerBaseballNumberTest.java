package baseball.model;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.exception.DuplicatedNumberException;
import baseball.exception.ErrorMessage;
import baseball.exception.InvalidFiguresNumberException;
import baseball.exception.InvalidInputTypeException;

public class PlayerBaseballNumberTest {

	@DisplayName("PlayBaseballNumber 객체 잘 생성되는지 Test")
	@Test
	void createPlayerNumberTest() {
		PlayerBaseballNumber.createPlayerBaseballNumber("275");
	}

	@DisplayName("PlayBaseballNumber 자리수 테스트 ")
	@Test
	void validateDuplicatedPlayerNumber() {
		assertThatThrownBy(() -> PlayerBaseballNumber.createPlayerBaseballNumber("11"))
			.isInstanceOf(InvalidFiguresNumberException.class)
			.hasMessageContaining(ErrorMessage.INVALID_FIGURES_NUMBER);
	}

	@DisplayName("PlayBaseballNumber 문자 포함 숫자 Test")
	@Test
	void validatePlayerNumberWithChar() {
		assertThatThrownBy(() -> PlayerBaseballNumber.createPlayerBaseballNumber("ab1"))
			.isInstanceOf(InvalidInputTypeException.class)
			.hasMessageContaining(ErrorMessage.INVALID_INPUT_TYPE);

	}
}
