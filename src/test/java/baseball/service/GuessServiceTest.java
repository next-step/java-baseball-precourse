package baseball.service;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GuessServiceTest {

	@Test
	@DisplayName("유저 인풋이 너무 길때 에러 테스트")
	public void test1() throws Exception {
		GuessService guessService = new GuessService();

		Assertions.assertThatThrownBy(() -> {
			guessService.checkUserInput("1234");
		}).isInstanceOf(IllegalArgumentException.class);
	}


}