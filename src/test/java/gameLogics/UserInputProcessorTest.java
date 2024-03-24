package gameLogics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static gameLogics.BaseRule.GAME_NUMBER_LENGTH;

@DisplayName("유저 입력 프로세싱 테스트")
class UserInputProcessorTest {

	@Test
	@DisplayName("유저 입력 검증 테스트 - 오답")
	void validateInputStringFails() {
		String userInput = "";
		assertThat(UserInputProcessor.validateInputString(userInput)).isEqualTo(false);
		userInput="12";
		assertThat(UserInputProcessor.validateInputString(userInput)).isEqualTo(false);
		userInput="3 12";
		assertThat(UserInputProcessor.validateInputString(userInput)).isEqualTo(false);
		userInput="112";
		assertThat(UserInputProcessor.validateInputString(userInput)).isEqualTo(false);
		userInput="12k";
		assertThat(UserInputProcessor.validateInputString(userInput)).isEqualTo(false);
		userInput="12e";
		assertThat(UserInputProcessor.validateInputString(userInput)).isEqualTo(false);

	}
	@Test
	@DisplayName("유저 입력 검증 테스트 - 정답")
	void validateInputStringPass() {
		String userInput = "516";
		assertThat(UserInputProcessor.validateInputString(userInput)).isEqualTo(true);
		userInput="123";
		assertThat(UserInputProcessor.validateInputString(userInput)).isEqualTo(true);
		userInput="312";
		assertThat(UserInputProcessor.validateInputString(userInput)).isEqualTo(true);
		userInput="912";
		assertThat(UserInputProcessor.validateInputString(userInput)).isEqualTo(true);
		userInput="987";
		assertThat(UserInputProcessor.validateInputString(userInput)).isEqualTo(true);
		userInput="524";
		assertThat(UserInputProcessor.validateInputString(userInput)).isEqualTo(true);

	}

	@Test
	@DisplayName("유저 입력 파싱 테스트")
	void digestValidatedInputString() {
		String userInput="524";
		List<Integer> digestedResult = new ArrayList<>();
		digestedResult.add(5);
		digestedResult.add(2);
		digestedResult.add(4);
		assertThat(UserInputProcessor.digestValidatedInputString(userInput).size()).isEqualTo(3);
		assertThat(UserInputProcessor.digestValidatedInputString(userInput)).containsAll(digestedResult);
	}
}